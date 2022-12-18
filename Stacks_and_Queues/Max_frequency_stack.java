/*
 * Problem Description
You are given a matrix A of size N x 2 which represents different operations.
Assume initially you have a stack-like data structure you have to perform operations on it.

Operations are of two types:

1 x: push an integer x onto the stack and return -1.

2 0: remove and return the most frequent element in the stack.

If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.

A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.



Problem Constraints
1 <= N <= 100000

1 <= A[i][0] <= 2

0 <= A[i][1] <= 109



 */
package Stacks_and_Queues;

import java.util.*;

public class Max_frequency_stack {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).get(0) == 1) {
                stack.add(A.get(i).get(1));
                map.put(A.get(i).get(1), map.getOrDefault(A.get(i).get(1), 0) + 1);
                ans.add(-1);
            } else {
                int max = Integer.MIN_VALUE;
                for (int key : map.keySet()) {
                    max = Math.max(max, map.get(key));
                }
                Stack<Integer> temp = new Stack<>();
                while (!stack.isEmpty()) {
                    int pop = stack.pop();
                    if (map.get(pop) == max) {
                        map.put(pop, map.get(pop) - 1);
                        ans.add(pop);
                        break;
                    } else {
                        temp.add(pop);
                    }
                }
                while (!temp.isEmpty()) {
                    stack.add(temp.pop());
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Max_frequency_stack m = new Max_frequency_stack();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 5)));
        A.add(new ArrayList<>(Arrays.asList(1, 7)));
        A.add(new ArrayList<>(Arrays.asList(1, 5)));
        A.add(new ArrayList<>(Arrays.asList(1, 7)));
        A.add(new ArrayList<>(Arrays.asList(1, 4)));
        A.add(new ArrayList<>(Arrays.asList(1, 5)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        A.add(new ArrayList<>(Arrays.asList(2, 0)));
        System.out.println(m.solve(A));
    }
}
    }
}

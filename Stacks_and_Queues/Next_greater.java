/*
 * Problem Description
Given an array A, find the next greater element G[i] for every element A[i] in the array.
The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.

More formally:

G[i] for an element A[i] = an element A[j] such that 
    j is minimum possible AND 
    j > i AND
    A[j] > A[i]
Elements for which no greater element exists, consider the next greater element as -1.



Problem Constraints
1 <= |A| <= 105

1 <= A[i] <= 107
 */
package Stacks_and_Queues;

import java.util.*;

public class Next_greater {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        Collections.reverse(result);
        return result;
    }
    public static void main(String[] args) {
        Next_greater n = new Next_greater();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        System.out.println(n.nextGreater(A));
    }
    
}

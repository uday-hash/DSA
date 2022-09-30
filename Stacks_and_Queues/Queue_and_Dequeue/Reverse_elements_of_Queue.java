/*
 * Problem Description
Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.

NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.



Problem Constraints
1 <= B <= length of the array <= 500000
1 <= A[i] <= 100000


 */
package Stacks_and_Queues.Queue_and_Dequeue;

import java.util.*;

public class Reverse_elements_of_Queue {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < A.size(); i++) {
            queue.add(A.get(i));
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < B; i++) {
            stack.add(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i = 0; i < A.size() - B; i++) {
            queue.add(queue.remove());
        }
        A.clear();
        A.addAll(queue);
        return A;
    }

    public static void main(String[] args) {
        Reverse_elements_of_Queue r = new Reverse_elements_of_Queue();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 3;
        System.out.println(r.solve(A, B));
    }
}
    
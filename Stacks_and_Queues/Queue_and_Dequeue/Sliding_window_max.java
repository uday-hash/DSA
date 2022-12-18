/*
 * Problem Description
Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.

Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].

Refer to the given example for clarity.

NOTE: If B > length of the array, return 1 element with the max of the array.



Problem Constraints
1 <= |A|, B <= 106
 */

package Stacks_and_Queues.Queue_and_Dequeue;

import java.util.*;

public class Sliding_window_max {
    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            while (!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        for (int i = B; i < A.size(); i++) {
            result.add(A.get(deque.peekFirst()));
            while (!deque.isEmpty() && deque.peekFirst() <= i - B) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && A.get(i) >= A.get(deque.peekLast())) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result.add(A.get(deque.peekFirst()));
        return result;
    }
    public static void main(String[] args) {
        Sliding_window_max s = new Sliding_window_max();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(-1);
        A.add(-3);
        A.add(5);
        A.add(3);
        A.add(6);
        A.add(7);
        System.out.println(s.slidingMaximum(A, 3));
    }
}

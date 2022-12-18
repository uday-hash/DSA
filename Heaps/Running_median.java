/*
 * Problem Description
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
 */
package Heaps;

import java.util.*;

public class Running_median {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (minHeap.size() == 0 || minHeap.peek() > A.get(i)) {
                maxHeap.add(A.get(i));
            } else {
                minHeap.add(A.get(i));
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            C.add(maxHeap.peek());
        }
        return C;
    }
    public static void main(String[] args) {
        Running_median rm = new Running_median();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(4);
        A.add(3);
        ArrayList<Integer> C = rm.solve(A);
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i) + " ");
        }
    }
}
    
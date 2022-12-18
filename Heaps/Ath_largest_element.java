/*
 * Problem Description
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i],
 where i varies from 1 to N. In other words, find the Ath largest 
 element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output
 should be -1 at the ith index.



Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX
 */

package Heaps;

import java.util.*;

public class Ath_largest_element {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            if (minHeap.size() < A) {
                minHeap.add(B.get(i));
            } else if (minHeap.peek() < B.get(i)) {
                minHeap.poll();
                minHeap.add(B.get(i));
            }
            if (minHeap.size() < A) {
                C.add(-1);
            } else {
                C.add(minHeap.peek());
            }
        }
        return C;
    }
    public static void main(String[] args) {
        Ath_largest_element ale = new Ath_largest_element();
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(5);
        ArrayList<Integer> C = ale.solve(3, B);
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i) + " ");
        }
    }
}

/*
 * Problem Description
Given two integers arrays, A and B, of size N each.

Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in arrays A and B.



Problem Constraints
1 <= N <= 2 * 105

-1000 <= A[i], B[i] <= 1000
 */
package Heaps;

import java.util.*;

public class N_max_pair_combinations {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A, Collections.reverseOrder());
        Collections.sort(B, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if (minHeap.size() < A.size()) {
                    minHeap.add(A.get(i) + B.get(j));
                } else if (minHeap.peek() < A.get(i) + B.get(j)) {
                    minHeap.poll();
                    minHeap.add(A.get(i) + B.get(j));
                } else {
                    break;
                }
            }
        }
        while (minHeap.size() > 0) {
            C.add(minHeap.poll());
        }
        Collections.sort(C, Collections.reverseOrder());
        return C;
    }

    public static void main(String[] args) {
        N_max_pair_combinations nmpc = new N_max_pair_combinations();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(4);
        A.add(2);
        A.add(3);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2);
        B.add(5);
        B.add(1);
        B.add(6);
        ArrayList<Integer> C = nmpc.solve(A, B);
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i) + " ");
        }
    }
}

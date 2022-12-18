/*
 * Problem Description
Given a sorted matrix of integers A of size N x M and an integer B.

Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.

NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.



Problem Constraints
1 <= N, M <= 500

1 <= A[i] <= 109

1 <= B <= N * M
 */
package Heaps;

import java.util.*;

public class Kth_smallest_element_sorted_matrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                pq.add(A.get(i).get(j));
                if (pq.size() > B) {
                    pq.poll();
                }
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        Kth_smallest_element_sorted_matrix ksesm = new Kth_smallest_element_sorted_matrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> A1 = new ArrayList<>();
        A1.add(1);
        A1.add(2);
        A1.add(3);
        A1.add(4);
        A.add(A1);
        ArrayList<Integer> A2 = new ArrayList<>();
        A2.add(2);
        A2.add(3);
        A2.add(4);
        A2.add(5);
        A.add(A2);
        ArrayList<Integer> A3 = new ArrayList<>();
        A3.add(3);
        A3.add(4);
        A3.add(5);
        A3.add(6);
        A.add(A3);
        ArrayList<Integer> A4 = new ArrayList<>();
        A4.add(4);
        A4.add(5);
        A4.add(6);
        A4.add(7);
        A.add(A4);
        System.out.println(ksesm.solve(A, 4));
    }
}

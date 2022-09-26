/*
 * Problem Description
Given a matrix of integers A of size N x M in which each row is sorted.

Find and return the overall median of matrix A.

NOTE: No extra memory is allowed.

NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N, M <= 10^5

1 <= N*M <= 10^6

1 <= A[i] <= 10^9

N*M is odd


 */
package Binary_search;

import java.util.ArrayList;

public class Matrix_Median {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, A.get(i).get(0));
            high = Math.max(high, A.get(i).get(m - 1));
        }
        int median = (n * m + 1) / 2;
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += upperBound(A.get(i), mid);
            }
            if (count < median) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public int upperBound(ArrayList<Integer> A, int target) {
        int low = 0, high = A.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        Matrix_Median m = new Matrix_Median();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        row1.add(3);
        row1.add(5);
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(2);
        row2.add(6);
        row2.add(9);
        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.add(3);
        row3.add(6);
        row3.add(9);
        A.add(row1);
        A.add(row2);
        A.add(row3);
        System.out.println(m.findMedian(A));
    }
}

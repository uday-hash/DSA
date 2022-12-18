/*
 * Problem Description
Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.

This matrix A has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than or equal to the last integer of the previous row.
Return 1 if B is present in A, else return 0.

NOTE: Rows are numbered from top to bottom, and columns are from left to right.



Problem Constraints
1 <= N, M <= 1000
1 <= A[i][j], B <= 106
 */
package Binary_search;

import java.util.ArrayList;

public class Matrix_search {
    public int searchMatrix(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int m = A.get(0).size();
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (A.get(row).get(col) == B) {
                return 1;
            } else if (A.get(row).get(col) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Matrix_search m = new Matrix_search();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        row1.add(3);
        row1.add(5);
        row1.add(7);
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(10);
        row2.add(11);
        row2.add(16);
        row2.add(20);
        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.add(23);
        row3.add(30);
        row3.add(34);
        row3.add(50);
        A.add(row1);
        A.add(row2);
        A.add(row3);
        System.out.println(m.searchMatrix(A, 3));
        System.out.println(m.searchMatrix(A, 13));
    }
    
}

/*
 * Problem Description
You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero.



Problem Constraints
1 <= A.size() <= 103

1 <= A[i].size() <= 103

0 <= A[i][j] <= 103
 */

import java.util.ArrayList;

public class Row_to_column_zero {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < m; j++){
                row.add(A.get(i).get(j));
            }
            B.add(row);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (A.get(i).get(j) == 0){
                    for (int k = 0; k < m; k++){
                        B.get(i).set(k, 0);
                    }
                    for (int k = 0; k < n; k++){
                        B.get(k).set(j, 0);
                    }
                }
            }
        }
        return B;
    }
    public static void main(String[] args) {
              Row_to_column_zero obj = new Row_to_column_zero();
                  ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
                 ArrayList<Integer> row1 = new ArrayList<Integer>();
                 row1.add(1);
                 row1.add(0);
                 row1.add(1);
                 ArrayList<Integer> row2 = new ArrayList<Integer>();
                 row2.add(1);
                 row2.add(1);
                 row2.add(1);
                 ArrayList<Integer> row3 = new ArrayList<Integer>();
                 row3.add(1);
                 row3.add(1);
                 row3.add(1);
                 A.add(row1);
                 A.add(row2);
                 A.add(row3);
                 System.out.println(obj.solve(A));
    
    }
}
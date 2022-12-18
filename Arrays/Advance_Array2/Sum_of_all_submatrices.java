/*
 * Problem Description
Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.



Problem Constraints
1 <= N <=30

0 <= A[i][j] <= 10


 */

package Arrays.Advance_Array2;

import java.util.ArrayList;

public class Sum_of_all_submatrices {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = A.get(i).get(j);
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sum += (i + 1) * (j + 1) * (n - i) * (n - j) * arr[i][j];
            }
        }
        return sum;
        
    }
    public static void main(String[] args) {
        Sum_of_all_submatrices obj = new Sum_of_all_submatrices();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        A.add(a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(1);
        A.add(b);
        System.out.println(obj.solve(A));
    }
    
}

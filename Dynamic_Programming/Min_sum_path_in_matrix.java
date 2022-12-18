/*
 * Problem Description
Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Return the minimum sum of the path.

NOTE: You can only move either down or right at any point in time.



Problem Constraints
1 <= M, N <= 2000

-1000 <= A[i][j] <= 1000
 */
package Dynamic_Programming;

import java.util.*;

public class Min_sum_path_in_matrix {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] dp = new int[m][n];
        dp[0][0] = A.get(0).get(0);
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+A.get(i).get(0);
        }
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1]+A.get(0).get(j);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+A.get(i).get(j);
            }
        }
        return dp[m-1][n-1];
        
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        A.add(a);
        a = new ArrayList<>();
        a.add(4);
        a.add(3);
        a.add(1);
        A.add(a);
        a = new ArrayList<>();
        a.add(5);
        a.add(6);
        a.add(1);
        A.add(a);
        System.out.println(new Min_sum_path_in_matrix().minPathSum(A));
    }
    
}

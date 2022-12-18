/*Problem Description
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

Adjacent numbers for jth number of row i is jth and (j+1)th numbers of row i+1 is



Problem Constraints
|A| <= 1000

A[i] <= 1000

 */

package Dynamic_Programming;

import java.util.*;

public class Min_sum_path_in_triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[][] dp = new int[n][n];
        dp[0][0] = a.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + a.get(i).get(0);
            dp[i][i] = dp[i - 1][i - 1] + a.get(i).get(i);
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + a.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
    
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        A.add(a);
        a = new ArrayList<>();
        a.add(3);
        a.add(4);
        A.add(a);
        a = new ArrayList<>();
        a.add(6);
        a.add(5);
        a.add(7);
        A.add(a);
        a = new ArrayList<>();
        a.add(4);
        a.add(1);
        a.add(8);
        a.add(3);
        A.add(a);
        System.out.println(new Min_sum_path_in_triangle().minimumTotal(A));
    }
}

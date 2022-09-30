/*
 * Problem Description
Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.

Also given an integer C which represents knapsack capacity.

Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.

NOTE:

You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).


Problem Constraints
1 <= N <= 103

1 <= C <= 103

1 <= A[i], B[i] <= 103
 */
package Graphs;

import java.util.*;

public class Knapsack {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        int[][] dp = new int[A.size() + 1][C + 1];
        for (int i = 1; i <= A.size(); i++) {
            for (int j = 1; j <= C; j++) {
                if (j >= B.get(i - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], A.get(i - 1) + dp[i - 1][j - B.get(i - 1)]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[A.size()][C];
    }

    public static void main(String[] args) {
        System.out.println(new Knapsack().solve(new ArrayList<>(Arrays.asList(60, 100, 120)), new ArrayList<>(Arrays.asList(10, 20, 30)), 50));
    }
}

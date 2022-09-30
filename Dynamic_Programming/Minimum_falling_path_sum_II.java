/*
 * Problem Description

Given a square grid of integers A, a falling path with non-zero shifts is a choice of exactly one element from each row of A, such that no two elements chosen in adjacent rows are in the same column.

Return the minimum sum of a falling path with non-zero shifts.



Problem Constraints

1 <= |A| == |A[i]| <= 200
-99 <= A[i][j] <= 99
 */
package Dynamic_Programming;

import java.util.*;

public class Minimum_falling_path_sum_II {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = A.get(i).get(j);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        min = Math.min(min, dp[i - 1][k]);
                    }
                }
                dp[i][j] += min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}

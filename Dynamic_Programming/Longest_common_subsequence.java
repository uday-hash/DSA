/*
 * Problem Description
Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.

You need to return the length of such longest common subsequence.



Problem Constraints
1 <= Length of A, B <= 1005
 */
package Dynamic_Programming;

import java.util.*;

public class Longest_common_subsequence {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        System.out.println(new Longest_common_subsequence().solve("abb", "ab"));
    }
}
    
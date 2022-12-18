/*
 * Problem Description
Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).

You need to return the length of longest palindromic subsequence.



Problem Constraints
1 <= length of(A) <= 103
 */

package Dynamic_Programming;

public class Longest_palindrome_subsequence {
    public int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (A.charAt(j) == A.charAt(j + i)) {
                    dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                } else {
                    dp[j][j + i] = Math.max(dp[j + 1][j + i], dp[j][j + i - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        System.out.println(new Longest_palindrome_subsequence().solve("abba"));
    }
}
    
    
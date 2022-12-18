/*
 * Problem Description
Given a string A, partition A such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of A.



Problem Constraints
1 <= length(A) <= 501


 */
package Dynamic_Programming;

public class Palindrome_partitioning_II {
    public int minCut(String A) {
        int n = A.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                if (A.charAt(j) == A.charAt(j + i)) {
                    if (i == 1) {
                        isPalindrome[j][j + i] = true;
                    } else {
                        isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1];
                    }
                }
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], 1 + dp[j]);
                    }
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome_partitioning_II().minCut("aab"));
    }
}

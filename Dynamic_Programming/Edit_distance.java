/*
 * Problem Description
Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Problem Constraints
1 <= length(A), length(B) <= 450


 */
package Dynamic_Programming;

public class Edit_distance {
    public int minDistance(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new Edit_distance().minDistance("abad", "abac"));
    }
}

/*
 * Problem Description
Given A, B, C find whether C is formed by the interleaving of A and B.



Problem Constraints
1 <= length(A), length(B) <= 100

1 <= length(C) <= 200
 */
package Dynamic_Programming;

public class Interleaving_strings {
    public int isInterleave(String A, String B, String C) {
        int n = A.length();
        int m = B.length();
        if (n + m != C.length()) {
            return 0;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (A.charAt(i - 1) == C.charAt(i - 1) && dp[i - 1][0]) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            if (B.charAt(i - 1) == C.charAt(i - 1) && dp[0][i - 1]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == C.charAt(i + j - 1) && dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (B.charAt(j - 1) == C.charAt(i + j - 1) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }
    public static void main(String[] args) {
        System.out.println(new Interleaving_strings().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new Interleaving_strings().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}        


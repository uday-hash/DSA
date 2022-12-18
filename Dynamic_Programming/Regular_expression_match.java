/*
 * Problem Description
Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.

' ? ' : Matches any single character.
' * ' : Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).



Problem Constraints
1 <= length(A), length(B) <= 104
 */
package Dynamic_Programming;

import java.util.*;

public class Regular_expression_match {
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (B.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (B.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (B.charAt(j - 1) == '?' || A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m] ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Regular_expression_match().isMatch("aa", "a"));
        System.out.println(new Regular_expression_match().isMatch("aa", "aa"));
        System.out.println(new Regular_expression_match().isMatch("aaa", "aa"));
        System.out.println(new Regular_expression_match().isMatch("aa", "*"));
        System.out.println(new Regular_expression_match().isMatch("aa", "a*"));
        System.out.println(new Regular_expression_match().isMatch("ab", "?*"));
        System.out.println(new Regular_expression_match().isMatch("aab", "c*a*b"));
    }
}

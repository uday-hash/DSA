/*
 * Problem Description

You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.

Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.



Problem Constraints

1 <= A <= 105
 */
package Dynamic_Programming;

public class Ways_to_send_the_signal {
    public int solve(int A) {
        int[] dp = new int[A + 1];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[A];
    }
    public static void main(String[] args) {
        System.out.println(new Ways_to_send_the_signal().solve(5));
    }
}
    
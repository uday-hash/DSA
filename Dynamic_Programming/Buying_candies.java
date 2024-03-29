/*
 * Problem Description
Rishik likes candies a lot. So, he went to a candy-shop to buy candies.

The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.

Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?


Problem Constraints
1 <= N <= 700

1 <= A[i] <= 1000

1 <= B[i] <= 1000

1 <= C[i],D <= 1000
 */
package Dynamic_Programming;

import java.util.*;

public class Buying_candies {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {
        int n = A.size();
        int[][] dp = new int[n + 1][D + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= D; j++) {
                if (j >= C.get(i - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], B.get(i - 1) * (j / C.get(i - 1)) + dp[i - 1][j % C.get(i - 1)]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][D];
    }
}

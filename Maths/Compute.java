/*
 * Problem Description
Given three integers A, B, and C, where A represents n, B represents r, a
nd C represents m, find and return the value of nCr % m 
where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.



Problem Constraints
1 <= A * B <= 106

1 <= B <= A

1 <= C <= 106
 */

package Maths;

public class Compute{
    public int solve(int A, int B, int C) {
        int n = A;
        int r = B;
        int m = C;
        int[][] dp = new int[n + 1][r + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % m;
                }
            }
        }
        return dp[n][r];

    }

    public static void main(String[] args) {
        Compute c = new Compute();
        System.out.println(c.solve(5, 2, 13));
    }
}

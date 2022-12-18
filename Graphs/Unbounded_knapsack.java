/*
 * Problem Description
Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.

This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.



Problem Constraints
1 <= A <= 1000

1 <= |B| <= 1000

1 <= B[i] <= 1000

1 <= C[i] <= 1000


 */
package Graphs;

import java.util.*;

public class Unbounded_knapsack {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int[][] dp = new int[B.size() + 1][A + 1];
        for (int i = 1; i <= B.size(); i++) {
            for (int j = 1; j <= A; j++) {
                if (j >= C.get(i - 1)) {
                    dp[i][j] = Math.max(dp[i - 1][j], B.get(i - 1) + dp[i][j - C.get(i - 1)]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[B.size()][A];
    }

    public static void main(String[] args) {
        System.out.println(new Unbounded_knapsack().solve(10, new ArrayList<>(Arrays.asList(1, 30)), new ArrayList<>(Arrays.asList(1, 50))));
    }
}
    

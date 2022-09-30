/*
 * Problem Description
Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.



Problem Constraints
1 <= length(A) <= 2500
0 <= A[i] <= 2500
 */
package Dynamic_Programming;

import java.util.*;

public class Longest_increasing_subsequence {
    public int lis(final List<Integer> A) {
        int n = A.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j)) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Longest_increasing_subsequence().lis(Arrays.asList(1, 2, 1, 5)));
    }
}

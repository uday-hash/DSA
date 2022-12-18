/*
 * Problem Description
You are given an integer array A of length N comprising of 0's & 1's, and an integer B.

You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.

A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.



Problem Constraints
1 <= N <= 103

A[i] equals to 0 or 1.

0 <= B <= (N - 1) / 2
 */
package Arrays.SubArrays;

import java.util.*;

public class Alternating_subarrays_easy {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (A.get(i) != A.get(i - 1)) {
                dp[i] = 1 + dp[i - 1];
            } else {
                dp[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[i] >= 2 * B + 1) {
                ans.add(i);
            }
        }
        return ans;

    }
}

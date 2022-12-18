/*
 *Problem Description

Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.

One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.

Find the maximum number of envelopes you can put one inside other.



Problem Constraints

1 <= N <= 1000
1 <= A[i][0], A[i][1] <= 109 
 */
package Dynamic_Programming;

import java.util.*;

public class Russian_doll_envelopes {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[] dp = new int[n];
        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A.get(j).get(0) < A.get(i).get(0) && A.get(j).get(1) < A.get(i).get(1)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(5, 4)));
        A.add(new ArrayList<>(Arrays.asList(6, 4)));
        A.add(new ArrayList<>(Arrays.asList(6, 7)));
        A.add(new ArrayList<>(Arrays.asList(2, 3)));
        System.out.println(new Russian_doll_envelopes().solve(A));
    }
}

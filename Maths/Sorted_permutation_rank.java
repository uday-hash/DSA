/*
 * Problem Description
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003



Problem Constraints
1 <= |A| <= 1000
 */

package Maths;

public class Sorted_permutation_rank {
    public int findRank(String A) {
        int n = A.length();
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % 1000003;
        }
        int rank = 1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    count++;
                }
            }
            rank = (rank + (count * fact[n - i - 1]) % 1000003) % 1000003;
        }
        return rank;
    }

    public static void main(String[] args) {
        Sorted_permutation_rank s = new Sorted_permutation_rank();
        System.out.println(s.findRank("acb"));
    }
}

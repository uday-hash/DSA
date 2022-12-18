/*
 * Problem Description
Given a string A, find the rank of the string amongst its permutations sorted lexicographically. Note that the characters might be repeated. If the characters are repeated, we need to look at the rank in unique permutations. Look at the example for more details.

NOTE:

The answer might not fit in an integer, so return your answer % 1000003 where 1000003 is a prime number.
String A can consist of both lowercase and uppercase letters. Characters with lesser ASCII values are considered smaller, i.e., 'a' > 'Z'.


Problem Constraints
1 <= len(A) <= 1000000
 */

package Maths;

public class Sorted_permutation_rank_with_repeats {
    public int findRank(String A) {
        int n = A.length();
        int[] count = new int[256];
        for (int i = 0; i < n; i++) {
            count[A.charAt(i)]++;
        }
        int[] fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % 1000003;
        }
        int res = 1;
        for (int i = 0; i < n; i++) {
            int less = 0;
            for (int j = 0; j < A.charAt(i); j++) {
                less += count[j];
            }
            res = (res + (less * fact[n - i - 1]) % 1000003) % 1000003;
            for (int j = A.charAt(i); j < 256; j++) {
                count[j]--;
            }
        }
        return res;
    }
}

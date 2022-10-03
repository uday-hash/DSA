/*
 * Problem Description
You are given a string A of length N consisting of lowercase alphabets. Find the period of the string.

Period of the string is the minimum value of k (k >= 1), that satisfies A[i] = A[i % k] for all valid i.



Problem Constraints
1 <= N <= 106
 */
package Strings;

public class Period_of_a_string {
    public int solve(String A) {
        int n = A.length();
        int[] lps = new int[n];
        int i = 1, j = 0;
        while(i < n) {
            if(A.charAt(i) == A.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            }
            else {
                if(j != 0)
                    j = lps[j - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return n - lps[n - 1];
    }
    public static void main(String[] args) {
        Period_of_a_string obj = new Period_of_a_string();
        System.out.println(obj.solve("ababab"));
    }
}

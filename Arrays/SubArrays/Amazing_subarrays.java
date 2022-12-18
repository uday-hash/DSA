/*
 * You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
 */
package Arrays.SubArrays;

import java.util.*;

public class Amazing_subarrays {
    public int solve(String A) {
        int mod = 10003;
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O'
                    || ch == 'U') {
                count += A.length() - i;
            }
        }
        return count % mod;
    }
    
}

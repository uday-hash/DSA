/*
 * Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.

Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.



Problem Constraints

1 <= Length of string B <= 1000

1 <= A <= 1000

All the alphabets of S are lower case (a - z)
 */
package Hashing;

public class Replicating_substring {
    public int solve(int A, String B) {
        int[] freq = new int[26];
        for(int i = 0; i < B.length(); i++)
            freq[B.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++) {
            if(freq[i] % A != 0)
                return -1;
        }
        return 1;
    }
    public static void main(String[] args) {
        Replicating_substring obj = new Replicating_substring();
        System.out.println(obj.solve(2, "aabb"));
    }
}

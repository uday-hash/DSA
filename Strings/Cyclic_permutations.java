/*
 * Problem Description
Given two binary strings A and B, count how many cyclic shift of B when taken XOR with A give 0.

NOTE: If there is a string, S0, S1, ... Sn-1 , then it is a cyclic shift is of the form Sk, Sk+1, ... Sn-1, S0, S1, ... Sk-1 where k can be any integer from 0 to N-1.



Problem Constraints
1 ≤ length(A) = length(B) ≤ 105
 */
package Strings;

public class Cyclic_permutations {
    public int solve(String A, String B) {
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(isEqual(A, B, i))
                count++;
        }
        return count;
    }

    public boolean isEqual(String A, String B, int k) {
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt((i + k) % A.length()) != B.charAt(i))
                return false;
        }
        return true;
    }
}

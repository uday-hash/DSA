/*
 * Problem Description
Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of set bits in X equals B.



Problem Constraints
0 <= A <= 109
0 <= B <= 30
 */

package Bit_manipulation;

public class Smallest_XOR {
    public int solve(int A, int B) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            if ((A & (1 << i)) == 0) {
                if (count < B) {
                    ans |= (1 << i);
                    count++;
                }
            }
        }
        return ans;
    }

}

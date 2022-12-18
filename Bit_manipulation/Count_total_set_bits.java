/*
 * Problem Description

Given a positive integer A, the task is to count the total number of set bits in the binary representation of all the numbers from 1 to A.

Return the count modulo 109 + 7.



Problem Constraints

1 <= A <= 109


 */
package Bit_manipulation;

public class Count_total_set_bits {
    public int solve(int A) {
        int mod = 1000000007;
        int count = 0;
        for (int i = 1; i <= A; i++) {
            count += countSetBits(i);
        }
        return count % mod;

    }

    public int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Count_total_set_bits obj = new Count_total_set_bits();
        System.out.println(obj.solve(4));
    }

}

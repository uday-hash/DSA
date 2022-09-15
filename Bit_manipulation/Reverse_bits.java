/*
 * Problem Description
Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 232
 */

package Bit_manipulation;

public class Reverse_bits {
    public long reverse(long A) {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result = result << 1;
            if ((A & 1) == 1) {
                result = result ^ 1;
            }
            A = A >> 1;
        }
        return result;
    }
    public static void main(String[] args) {
        Reverse_bits rb = new Reverse_bits();
        System.out.println(rb.reverse(3));
    }
    
}

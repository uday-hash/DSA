/*
 * Problem Description
Divide two integers without using multiplication, division and mod operator.

Return the floor of the result of the division.

Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.

NOTE: INT_MAX = 2^31 - 1



Problem Constraints
-231 <= A, B <= 231-1

B != 0
 */

package Bit_manipulation;

public class Divide_integers {
    public int divide(int A, int B) {
        if (A == Integer.MIN_VALUE && B == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = ((A < 0) ^ (B < 0)) ? -1 : 1;
        long a = Math.abs((long)A);
        long b = Math.abs((long)B);
        int res = 0;
        while (a - b >= 0) {
            long x = 0;
            while (a - (b << 1 << x) >= 0) {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return sign * res;
    }
    
    public static void main(String[] args) {
        Divide_integers d = new Divide_integers();
        System.out.println(d.divide(-2147483648, 1));
    }
}
/*Problem Description
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.



Problem Constraints
1 <= A <= 109
 */

package Bit_manipulation;

public class Strange_equality {
    public int solve(int A) {
        int x = A - 1;
        int y = A + 1;
        while (x > 0) {
            if ((x ^ A) == (x + A)) {
                break;
            }
            x--;
        }
        while (y > 0) {
            if ((y ^ A) == (y + A)) {
                break;
            }
            y++;
        }
        return x ^ y;    
    }
    public static void main(String[] args) {
        Strange_equality s = new Strange_equality();
        System.out.println(s.solve(5));
    }
}

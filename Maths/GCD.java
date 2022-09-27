/*
 * Problem Description
Given 2 non-negative integers A and B, find gcd(A, B)

GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.

Note: DO NOT USE LIBRARY FUNCTIONS.



Problem Constraints
0 <= A, B <= 109


 */

package Maths;

public class GCD {
    public int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);

    }

    

    public static void main(String[] args) {
        GCD g = new GCD();
        System.out.println(g.gcd(6, 9));
    }
    
}

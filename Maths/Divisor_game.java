/*
 * Problem Description
Scooby has 3 three integers A, B, and C.

Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.



Problem Constraints
1 <= A, B, C <= 109



 */

package Maths;

public class Divisor_game {
    public int solve(int A, int B, int C) {
        int gcd = gcd(B, C);
        int lcm = (B * C) / gcd;
        return A / lcm;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Divisor_game d = new Divisor_game();
        System.out.println(d.solve(10, 2, 3));
    }
    
}

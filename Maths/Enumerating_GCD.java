/*
 * Problem Description
You are given a number A and a number B. Greatest Common Divisor (GCD) of all 
numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
As this problem looks a bit easy, it is given that numbers A and B can be in the 
range of 10100.

You have to return the value of GCD found.

The greatest common divisor of 2 numbers, A and B, is the largest number, D that 
divides both A and B perfectly.



Problem Constraints
1 <= A <= B <= 10100
 */

package Maths;

public class Enumerating_GCD {
    public String solve(String A, String B) {
        long a = Long.parseLong(A);
        long b = Long.parseLong(B);
        long gcd = 1;
        for (long i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                if (b % i == 0) {
                    gcd = i;
                }
                if (b % (a / i) == 0) {
                    gcd = a / i;
                }
            }
        }
        return String.valueOf(gcd);
    }

    public static void main(String[] args) {
        Enumerating_GCD e = new Enumerating_GCD();
        System.out.println(e.solve("100", "100"));
    }
}

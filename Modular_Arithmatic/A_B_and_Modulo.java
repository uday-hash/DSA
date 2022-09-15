/*
 * Problem Description
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.



Problem Constraints
1 <= A, B <= 109
A != B
 */

package Modular_Arithmatic;

public class A_B_and_Modulo {
    public int solve(int A, int B) {
        return Math.abs(A - B);
    }
}

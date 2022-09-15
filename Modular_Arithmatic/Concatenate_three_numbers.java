/*
 * Problem Description
Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating them in any order.

Return the minimum result obtained.



Problem Constraints
10 <= A, B, C <= 99


 */

package Modular_Arithmatic;

public class Concatenate_three_numbers {
    public int solve(int A, int B, int C) {
        int min = Math.min(A, Math.min(B, C));
        int max = Math.max(A, Math.max(B, C));
        int mid = A + B + C - min - max;
        return min * 10000 + mid * 100 + max;
        
        
    }
    public static void main(String[] args) {
        Concatenate_three_numbers ctn = new Concatenate_three_numbers();
        System.out.println(ctn.solve(10, 20, 30));
        System.out.println(ctn.solve(10, 20, 30));
        System.out.println(ctn.solve(10, 20, 30));
        
    }
    
}

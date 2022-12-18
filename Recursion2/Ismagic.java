/*
 * Problem Description
Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.



Problem Constraints
1 <= A <= 109

Avoid Stackoverflow error

 */

package Recursion2;

public class Ismagic {
    public int solve(int A) {
        if(A < 10){
            if(A == 1){
                return 1;
            }
            return 0;
        }
        int sum = 0;
        while(A > 0){
            sum += A%10;
            A = A/10;
        }
        return solve(sum);
    }
    public static void main(String[] args) {
        Ismagic obj = new Ismagic();
        int A = 1291;
        System.out.println(obj.solve(A));
    }
}

/*
 * Problem Description
Write a program to find the factorial of the given number A.



Problem Constraints
0 <= A <= 12
 */

package Recursion;

public class Factorial {
    public int solve(int A){
        if(A == 1){
            return 1;
        }
        return A*solve(A-1);
    }
    public static void main(String[] args) {
        Factorial obj = new Factorial();
        int A = 5;
        System.out.println(obj.solve(A));
    }
}

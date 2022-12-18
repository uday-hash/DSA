/*
 * Problem Description
You are given a number A in the form of a string. Check if the number is divisible by eight or not.

Return 1 if it is divisible by eight else, return 0.


Problem Constraints
1 <= length of the String <= 100000
'0' <= A[i] <= '9'

 */

package Modular_Arithmatic;

public class Divisibility_by_8 {
    public int solve(String A) {
        int n = A.length();
        if (n == 1) {
            int a = A.charAt(0) - '0';
            if (a % 8 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if (n == 2) {
            int a = A.charAt(0) - '0';
            int b = A.charAt(1) - '0';
            int c = a * 10 + b;
            if (c % 8 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            int a = A.charAt(n - 1) - '0';
            int b = A.charAt(n - 2) - '0';
            int c = A.charAt(n - 3) - '0';
            int d = c * 100 + b * 10 + a;
            if (d % 8 == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    public static void main(String[] args) {
        Divisibility_by_8 db8 = new Divisibility_by_8();
        System.out.println(db8.solve("1"));
        System.out.println(db8.solve("8"));
        System.out.println(db8.solve("16"));
        
    }
        
}

/*Problem Description
Write a program to input an integer T and then for each test case input two integers A and B in two different lines and then print T lines containing Least Common Multiple (LCM) of two given 2 numbers A and B.

LCM of two integers is the smallest positive integer divisible by both.



Problem Constraints
1 <= T <= 1000

1 <= A,B <= 1000 */

package Modular_Arithmatic;

import java.util.Scanner;

public class Least_common_multiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int lcm = (a * b) / gcd(a, b);
            System.out.println(lcm);
        }
        sc.close();

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    
}

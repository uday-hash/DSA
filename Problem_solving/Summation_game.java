/*'Problem Description

Write a program to find sum all Natural numbers from 1 to N where you have to take N as input from user


Problem Constraints

1 <= N <= 1000' */
package Problem_solving;

import java.util.*;

public class Summation_game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            sum = sum + j;
        }
        System.out.println(sum);
        sc.close();
    }
}


/*
 * Problem Description

Given an integer A, you have to tell whether it is a prime number or not.

A prime number is a natural number greater than 1 which is divisible only by 1 and itself.


Problem Constraints

1 <= A <= 106
 */
package Problem_solving;

import java.util.*;

public class Is_it_prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            boolean isPrime = true;
            for (int j = 2; j < num; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}

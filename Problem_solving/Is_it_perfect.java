

/*
 * Problem Description

You are given N positive integers.

For each given integer A, you have to tell whether it is a perfect number or not.

A perfect number is a positive integer which is equal to the sum of its proper positive divisors. 
A positive proper divisor divides a number without leaving any remainder.



Problem Constraints

1 <= N <= 10

1 <= A <= 106
 */

package Problem_solving;

import java.util.Scanner;

public class Is_it_perfect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int sum = 0;
            for (int j = 1; j < num; j++) {
                if(num % j == 0){
                    sum = sum+j;
                }
                
            }
            if(sum == num){
                System.out.println("yes");

            }else{
                System.out.println("No");
            }
            sc.close();
            
        }
    }
    
}

package com.company;

import java.util.Scanner;

public class Questions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       // int n = in.nextInt();
      //  int m = in.nextInt();
       // System.out.println(isPrime(n));
        for (int i = 100; i < 1000;i++){
            if(isArmstrong(i)){
                System.out.println(i + " ");
            }
        }
    }

    /// Armstrong numbers
    static boolean isArmstrong(int m){
        int original = m;
        int sum = 0;
        while(m>0){
            int rem = m % 10;
            m = m / 10;
            sum = sum + rem*rem*rem;
        }
        return sum == original;
    }


    static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        int c = 2;
        while(c *c <= n){
            if(n%c == 0){
                return false;
            }
            c++;
        }
        return c * c > n;
    }
}

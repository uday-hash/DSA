package com.company;
import java.util.Scanner;
public class frequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;
        while(n>0){
            int rem = n % 10;
            if(rem == 3){
                count++;
            }
            n = n / 10; // n /= 10  (getting next number )
        }
        System.out.println(count);
    }
}

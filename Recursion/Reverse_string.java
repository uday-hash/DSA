package Recursion;

import java.util.Scanner;

public class Reverse_string {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));


        sc.close();
    }
    public static String reverse(String str){
        int n = str.length();
        if(n == 1){
            return str;
        }
        return str.charAt(n-1) + reverse(str.substring(0, n-1));
    }
    
}

package com.company;
import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Take  in from user till user does not press X or x
        int ans = 0;

        while(true){

            System.out.println("Enter Operator: ");
            char ch = in.next().trim().charAt(0);
            if(ch == '+' || ch == '-' || ch == '/' || ch == '%') {
                System.out.print("Enter two numbers");
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                System.out.println();
                if (ch == '+') {
                    ans = n1 + n2;
                }
                if (ch == '-') {
                    ans = n1 - n2;
                }
                if (ch == '/') {
                    if (n2 != 0) {
                        ans = n1 / n2;
                    }
                }

                if (ch == '%') {
                    ans = n1 % n2;
                }
            }else if ( ch == 'x' || ch == 'X'){
                break;
            }else {
                System.out.println("Invalid Operation");
            }
            System.out.println(ans);
        }

    }
}

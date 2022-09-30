/*
 * Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints
1 <= length of the string <= 500000
 */
package Stacks_and_Queues;

import java.util.*;

public class Infix_to_posfix {
    public String solve(String A) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    str.append(stack.pop());
                }
                stack.pop();
            } else if (c == '^') {
                while (!stack.isEmpty() && stack.peek() == '^') {
                    str.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '/' || c == '*') {
                while (!stack.isEmpty() && (stack.peek() == '^' || stack.peek() == '/' || stack.peek() == '*')) {
                    str.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '+' || c == '-') {
                while (!stack.isEmpty() && (stack.peek() == '^' || stack.peek() == '/' || stack.peek() == '*' || stack.peek() == '+' || stack.peek() == '-')) {
                    str.append(stack.pop());
                }
                stack.push(c);
            } else {
                str.append(c);
            }
        }
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }
    

    public static void main(String[] args) {
        Infix_to_posfix i = new Infix_to_posfix();
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(i.solve(A));
    }
}
        
    
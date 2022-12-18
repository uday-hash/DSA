/*
 * Problem Description
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.



Problem Constraints
1 <= N <= 105
 */
package Stacks_and_Queues;

import java.util.*;

public class Evaluate_expression {
    public int evalRPN(ArrayList<String> A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            String s = A.get(i);
            if (s.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a + b);
            } else if (s.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if (s.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(a * b);
            } else if (s.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Evaluate_expression e = new Evaluate_expression();
        ArrayList<String> A = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "*"));
        System.out.println(e.evalRPN(A));
    }
}


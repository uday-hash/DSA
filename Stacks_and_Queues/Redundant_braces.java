/*
 * Problem Description
Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

Check whether A has redundant braces or not.

NOTE: A will be always a valid expression and will not contain any white spaces.



Problem Constraints
1 <= |A| <= 105
 */
package Stacks_and_Queues;

import java.util.*;

public class Redundant_braces {
    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    return 1;
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return 0;
    }
}

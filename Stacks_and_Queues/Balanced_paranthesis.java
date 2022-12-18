/*
 * Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100


 */
package Stacks_and_Queues;

import java.util.*;

public class Balanced_paranthesis {
    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return 0;
                }
                stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return 0;
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return 0;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Balanced_paranthesis b = new Balanced_paranthesis();
        System.out.println(b.solve("()"));
    }
}

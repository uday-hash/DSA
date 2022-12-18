/*
 * Problem Description
Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.

The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.

NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.



Problem Constraints
1 <= length of the each String <= 100
 */
package Stacks_and_Queues;

public class Check_two_bracket_expressions{
    public int solve(String A, String B) {
        if (A.length() != B.length()) {
            return 0;
        }
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '(' || A.charAt(i) == ')') {
                A = A.substring(0, i) + A.substring(i + 1);
                i--;
            }
        }
        for (int i = 0; i < B.length(); i++) {
            if (B.charAt(i) == '(' || B.charAt(i) == ')') {
                B = B.substring(0, i) + B.substring(i + 1);
                i--;
            }
        }
        if (A.equals(B)) {
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Check_two_bracket_expressions c = new Check_two_bracket_expressions();
        System.out.println(c.solve("a+b*(c^d-e)^(f+g*h)-i", "a+b*(c^d-e)^(f+g*h)-i"));
    }
}
    

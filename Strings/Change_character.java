/*
 * Problem Description
You are given a string A of size N consisting of lowercase alphabets.

You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.

Find the minimum number of distinct characters in the resulting string.



Problem Constraints
1 <= N <= 100000

0 <= B < N
 */

package Strings;

public class Change_character {
    public int solve(String A, int B) {
        
    }


    public static void main(String[] args) {
        Change_character obj = new Change_character();
        String A = "abcc";
        int B = 1;
        System.out.println(obj.solve(A, B));
    }

}

/*
 * Problem Description
You are given a string A.

An operation on the string is defined as follows:

Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".

Therefore the string after this operation will be "acd".

Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.



Problem Constraints
1 <= |A| <= 100000
 */
package Stacks_and_Queues;

public class Double_character_trouble {
    public String solve(String A) {
        StringBuilder str = new StringBuilder(A);
        int i = 0;
        while (i < str.length() - 1) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                str.delete(i, i + 2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return str.toString();
        
    }

    public static void main(String[] args) {
        Double_character_trouble d = new Double_character_trouble();
        String A = "abbcd";
        System.out.println(d.solve(A));
    }
}

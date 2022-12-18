/*
 * Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints
1 <= |A| <= 105

String A consist only of lowercase characters.
 */


 package Strings;

public class Simple_reverse {
    public String solve(String A) {
        StringBuilder ans = new StringBuilder();
        for(int i = A.length()-1; i >= 0; i--){
            ans.append(A.charAt(i));
        }
        return ans.toString();
        
    }

    public static void main(String[] args) {
        Simple_reverse obj = new Simple_reverse();
        String A = "Akash";
        System.out.println(obj.solve(A));
    }
    
}

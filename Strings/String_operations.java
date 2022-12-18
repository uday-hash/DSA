
/*
 * Problem Description

Akash likes playing with strings. One day he thought of applying following operations on the string in the given order:

Concatenate the string with itself.
Delete all the uppercase letters.
Replace each vowel with '#'.
You are given a string A of size N consisting of lowercase and uppercase alphabets. Return the resultant string after applying the above operations.

NOTE: 'a' , 'e' , 'i' , 'o' , 'u' are defined as vowels.



Problem Constraints

1<=N<=100000

 */

 package Strings;

public  class String_operations {
    public String solve(String A) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) >= 'a' && A.charAt(i) <= 'z'){
                ans.append(A.charAt(i));
            }
        }
        ans.append(ans);
        for(int i = 0; i < ans.length(); i++){
            if(ans.charAt(i) == 'a' || ans.charAt(i) == 'e' || ans.charAt(i) == 'i' || ans.charAt(i) == 'o' || ans.charAt(i) == 'u'){
                ans = new StringBuilder(ans.substring(0, i) + "#" + ans.substring(i + 1));
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String_operations obj = new String_operations();
        String A = "Akash";
        System.out.println(obj.solve(A));
    }
    
}

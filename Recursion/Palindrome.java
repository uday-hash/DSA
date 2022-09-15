/*
 * Problem Description
Write a recursive function that checks whether string A is a palindrome or Not.
Return 1 if the string A is a palindrome, else return 0.

Note: A palindrome is a string that's the same when read forward and backward.



Problem Constraints
1 <= |A| <= 50000

String A consists only of lowercase letters.


 */

package Recursion;

public class Palindrome {
    public int solve(String A){
        int n = A.length();
        if(n == 1){
            return 1;
        }
        if(n == 2){
            if(A.charAt(0) == A.charAt(1)){
                return 1;
            }
            return 0;
        }
        if(A.charAt(0) == A.charAt(n-1)){
            return solve(A.substring(1, n-1));
        }
        return 0;
    }
    public static void main(String[] args) {
        Palindrome obj = new Palindrome();
        String A = "abba";
        System.out.println(obj.solve(A));
    }

    
}

/*
 * Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000

 */
package Strings;

public class Longest_palindromic_substring {
    public String longestPalindrome(String A) {
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
        }
        for(int i = 0; i < n-1; i++){
            if(A.charAt(i) == A.charAt(i+1)){
                dp[i][i+1] = true;
                max = 2;
                start = i;
            }
        }
        for(int k = 3; k <= n; k++){
            for(int i = 0; i < n-k+1; i++){
                int j = i+k-1;
                if(dp[i+1][j-1] && A.charAt(i) == A.charAt(j)){
                    dp[i][j] = true;
                    if(k > max){
                        max = k;
                        start = i;
                    }
                }
            }
        }
        return A.substring(start, start+max);
    }
    public static void main(String[] args) {
        Longest_palindromic_substring obj = new Longest_palindromic_substring();
        String A = "abba";
        System.out.println(obj.longestPalindrome(A));
    }
    
}

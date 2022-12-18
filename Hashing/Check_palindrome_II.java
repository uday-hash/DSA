/*
 * Problem Description
Given a string A consisting of lowercase characters.

Check if characters of the given string can be rearranged to form a palindrome.

Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.



Problem Constraints
1 <= |A| <= 105

A consists only of lower-case characters.
 */
package Hashing;

public class Check_palindrome_II {
    public int solve(String A) {
        int[] freq = new int[26];
        for(int i = 0; i < A.length(); i++)
            freq[A.charAt(i) - 'a']++;
        int odd = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] % 2 != 0)
                odd++;
        }
        if(odd > 1)
            return 0;
        return 1;
    }
    public static void main(String[] args) {
        Check_palindrome_II obj = new Check_palindrome_II();
        System.out.println(obj.solve("abcba"));
    }
}

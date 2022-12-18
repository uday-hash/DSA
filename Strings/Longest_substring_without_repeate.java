/*
 * Problem Description
Given a string A, find the length of the longest substring without repeating characters.

Note: Users are expected to solve in O(N) time complexity.



Problem Constraints
1 <= size(A) <= 106

String consists of lowerCase,upperCase characters and digits are also present in the string A.
 */
package Strings;

public class Longest_substring_without_repeate {
    public int lengthOfLongestSubstring(String A) {
        int[] freq = new int[256];
        int start = 0;
        int end = 0;
        int max = 0;
        while (end < A.length()) {
            freq[A.charAt(end)]++;
            end++;
            while (freq[A.charAt(end - 1)] > 1) {
                freq[A.charAt(start)]--;
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }
    public static void main(String[] args) {
        Longest_substring_without_repeate obj = new Longest_substring_without_repeate();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
    }
}

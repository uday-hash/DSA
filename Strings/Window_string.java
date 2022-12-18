/*
 * Problem Description
Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.

Note:

If there is no such window in A that covers all characters in B, return the empty string.
If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )


Problem Constraints
1 <= size(A), size(B) <= 106
 */
package Strings;

public class Window_string {
    public String minWindow(String A, String B) {
        int[] freq = new int[256];
        for (int i = 0; i < B.length(); i++) {
            freq[B.charAt(i)]++;
        }
        int count = B.length();
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minEnd = Integer.MAX_VALUE;
        while (end < A.length()) {
            if (freq[A.charAt(end)] > 0) {
                count--;
            }
            freq[A.charAt(end)]--;
            end++;
            while (count == 0) {
                if (minEnd - minStart > end - start) {
                    minStart = start;
                    minEnd = end;
                }
                freq[A.charAt(start)]++;
                if (freq[A.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
        }
        if (minEnd == Integer.MAX_VALUE) {
            return "";
        }
        return A.substring(minStart, minEnd);
    }

    public static void main(String[] args) {
        Window_string obj = new Window_string();
        System.out.println(obj.minWindow("ADOBECODEBANC", "ABC"));
    }
}
    

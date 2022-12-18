/*
 * Problem Description
You are given two strings, A and B, of size N and M, respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105
 */
package Strings;

public class Permutations_of_A_in_B {
    public int solve(String A, String B) {
        int count = 0;
        int[] freq = new int[26];
        for(int i = 0; i < A.length(); i++)
            freq[A.charAt(i) - 'a']++;
        for(int i = 0; i < B.length() - A.length() + 1; i++) {
            int[] temp = new int[26];
            for(int j = i; j < i + A.length(); j++)
                temp[B.charAt(j) - 'a']++;
            if(isEqual(freq, temp))
                count++;
        }
        return count;

    }

    public boolean isEqual(int[] freq, int[] temp) {
        for(int i = 0; i < 26; i++) {
            if(freq[i] != temp[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Permutations_of_A_in_B obj = new Permutations_of_A_in_B();
        System.out.println(obj.solve("ab", "abab"));
    }
}

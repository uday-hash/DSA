/*Problem Description
Given a digit string A, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.

NOTE: Make sure the returned strings are lexicographically sorted.



Problem Constraints
1 <= |A| <= 10 */
package Back_Tracking;

import java.util.*;

public class Letter_phone {
    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> result = new ArrayList<>();
        if (A.length() == 0) {
            return result;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        for (int i = 0; i < A.length(); i++) {
            result = solve(result, map.get(A.charAt(i)));
        }
        return result;
    }
    public ArrayList<String> solve(ArrayList<String> A, String B)
    {
        ArrayList<String> result = new ArrayList<>();
        if (A.size() == 0) {
            for (int i = 0; i < B.length(); i++) {
                result.add(B.charAt(i) + "");
            }
            return result;
        }
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.length(); j++) {
                result.add(A.get(i) + B.charAt(j));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Letter_phone l = new Letter_phone();
        System.out.println(l.letterCombinations("23"));
    }
}

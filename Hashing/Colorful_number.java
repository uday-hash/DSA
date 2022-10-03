/*
 * Problem Description
Given a number A, find if it is COLORFUL number or not.

If number A is a COLORFUL number return 1 else, return 0.

What is a COLORFUL Number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.


Problem Constraints
1 <= A <= 2 * 109
 */
package Hashing;

import java.util.*;

public class Colorful_number {
    public int colorful(int A) {
        String str = Integer.toString(A);
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                if (map.containsKey(product))
                    return 0;
                else
                    map.put(product, 1);
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Colorful_number obj = new Colorful_number();
        System.out.println(obj.colorful(3245));
    }
}

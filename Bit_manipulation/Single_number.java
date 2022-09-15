/*
 * Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?



Problem Constraints
2 <= |A| <= 2000000

0 <= A[i] <= INTMAX
 */

 package Bit_manipulation;

import java.util.ArrayList;
import java.util.List;

public class Single_number {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(1);
        System.out.println(singleNumber(A));
    }

    public static int singleNumber(final List<Integer> A) {
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result = result ^ A.get(i);
        }
        return result;
    }
}
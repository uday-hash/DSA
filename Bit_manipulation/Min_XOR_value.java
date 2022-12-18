/*
 * Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109
 */
package Bit_manipulation;

import java.util.ArrayList;

public class Min_XOR_value {
    public int findMinXor(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                min = Math.min(min, A.get(i) ^ A.get(j));
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Min_XOR_value m = new Min_XOR_value();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0);
        A.add(4);
        A.add(7);
        A.add(9);
        System.out.println(m.findMinXor(A));
    }
}
/*
 * Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.


Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109
 */

package Bit_manipulation;

import java.util.ArrayList;

public class Single_number_III {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= A.get(i);
        }
        int set_bit = xor & ~(xor - 1);
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            if ((A.get(i) & set_bit) > 0) {
                x ^= A.get(i);
            } else {
                y ^= A.get(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Math.min(x, y));
        res.add(Math.max(x, y));
        return res;
        
    }

    public static void main(String[] args) {
        Single_number_III s = new Single_number_III();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(2);
        A.add(4);
        System.out.println(s.solve(A));
    }
    
}

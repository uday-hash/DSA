/*
 * Problem Description
Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.



Problem Constraints
2 <= N <= 105

-109 <= A[i] <= 109


 */

package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Arithmetic_progression {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        int diff = A.get(1) - A.get(0);
        for (int i = 2; i < n; i++) {
            if (A.get(i) - A.get(i - 1) != diff) {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Arithmetic_progression ap = new Arithmetic_progression();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(ap.solve(A));
        
    }

}

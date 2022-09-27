/*
 * Problem Description
Given an array of positive integers A, check and return whether the array elements are consecutive or not.
NOTE: Try this with O(1) extra space.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
 */
package Sorting;

import java.util.ArrayList;

public class Array_with_consecutive_elements {
    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < min) {
                min = A.get(i);
            }
            if (A.get(i) > max) {
                max = A.get(i);
            }
        }
        if (max - min + 1 != A.size()) {
            return 0;
        }
        int[] count = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            count[A.get(i) - min]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 1) {
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        Array_with_consecutive_elements obj = new Array_with_consecutive_elements();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(100);
        A.add(101);
        A.add(102);
        A.add(103);
        A.add(104);
        A.add(105);
        A.add(106);
        A.add(107);
        A.add(108);
        A.add(109);
        A.add(110);
    
      System.out.println(obj.solve(A)); 
      
    }
}

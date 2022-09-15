/*
 * Problem Description
Given an integer array A, find if an integer p exists in the array such that the number of integers greater than p in the array equals p.



Problem Constraints
1 <= |A| <= 2*105
1 <= A[i] <= 107

 */
package Sorting;

import java.util.ArrayList;
import java.util.Collections;

public class Noble_integer {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int n = A.size();
        for (int i = 0; i < n - 1; i++) {
            if (A.get(i) == A.get(i + 1)) {
                continue;
            }
            if (A.get(i) == n - i - 1) {
                return 1;
            }
        }
        if (A.get(n - 1) == 0) {
            return 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Noble_integer ni = new Noble_integer();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(ni.solve(A));
    }
    
}

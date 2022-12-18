/*
 * Problem Description
Given an integer array A of size N.

You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.

Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.



Problem Constraints
1 <= N <= 105
0 <= A[i] <= 103


 */

package Heaps;

import java.util.ArrayList;

public class Product_of_three {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> B = new ArrayList<>();
        if (A.size() < 3) {
            for (int i = 0; i < A.size(); i++) {
                B.add(-1);
            }
            return B;
        }
        int max1 = Math.max(A.get(0), A.get(1));
        int max2 = Math.min(A.get(0), A.get(1));
        int max3 = -1;
        B.add(-1);
        B.add(-1);
        for (int i = 2; i < A.size(); i++) {
            if (A.get(i) > max1) {
                max3 = max2;
                max2 = max1;
                max1 = A.get(i);
            } else if (A.get(i) > max2) {
                max3 = max2;
                max2 = A.get(i);
            } else if (A.get(i) > max3) {
                max3 = A.get(i);
            }
            B.add(max1 * max2 * max3);
        }
        return B;
    }

    public static void main(String[] args) {
        Product_of_three pot = new Product_of_three();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(pot.solve(A));
    }
}

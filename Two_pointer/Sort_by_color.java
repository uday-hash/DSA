/*
 * Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2
 */
package Two_pointer;

import java.util.*;

public class Sort_by_color {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int n = A.size();
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (A.get(j) == 0) {
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
                i++;
                j++;
            } else if (A.get(j) == 1)
                j++;
            else {
                int temp = A.get(j);
                A.set(j, A.get(k));
                A.set(k, temp);
                k--;
            }
        }
        return A;

    }
    public static void main(String[] args) {
        Sort_by_color obj = new Sort_by_color();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(0);
        A.add(1);
        A.add(2);
        System.out.println(obj.sortColors(A));
    }
}

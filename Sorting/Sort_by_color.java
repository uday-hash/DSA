/*
 *Problem Description
Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent red, white, and blue, respectively.

Note: Using the library sort function is not allowed.



Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2 
 */

package Sorting;

import java.util.ArrayList;

public class Sort_by_color {
    public ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int n = A.size();
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            switch (A.get(mid)) {
            case 0:
                swap(A, low, mid);
                low++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(A, mid, high);
                high--;
                break;
            }
        }
        return A;
        
    }
    public void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }
    public static void main(String[] args) {
        Sort_by_color sbc = new Sort_by_color();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(0);
        A.add(1);
        A.add(2);
        A.add(0);
        A.add(1);
        A.add(2);
        System.out.println(sbc.sortColors(A));
    }
    
}

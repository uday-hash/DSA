/*
 * Problem Description

Given an integer array A, sort the array using QuickSort.



Problem Constraints

1 <= |A| <= 105

1 <= A[i] <= 109
 */

package Sorting;

import java.util.ArrayList;

public class QuickSort {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        ArrayList<Integer> middle = new ArrayList<Integer>();
        int pivot = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) < pivot) {
                left.add(A.get(i));
            } else if (A.get(i) > pivot) {
                right.add(A.get(i));
            } else {
                middle.add(A.get(i));
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (left.size() > 1) {
            left = solve(left);
        }
        if (right.size() > 1) {
            right = solve(right);
        }
        result.addAll(left);
        result.addAll(middle);
        result.addAll(right);
        return result;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(1);
        System.out.println(q.solve(A));
    }
} 
 
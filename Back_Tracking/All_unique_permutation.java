/*
 * Problem Description
Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9

0 <= A[i] <= 10
 */
package Back_Tracking;

import java.util.*;

public class All_unique_permutation {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        A.sort(null);
        permute(A, result, current);
        return result;
    }

    public void permute(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current) {
        if (A.size() == 0) {
            result.add(new ArrayList<Integer>(current));
        }
        for (int i = 0; i < A.size(); i++) {
            if (i > 0 && A.get(i) == A.get(i - 1)) {
                continue;
            }
            current.add(A.get(i));
            ArrayList<Integer> temp = new ArrayList<Integer>(A);
            temp.remove(i);
            permute(temp, result, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        All_unique_permutation s = new All_unique_permutation();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(1);
        A.add(2);
        System.out.println(s.permute(A));
    }
}
    
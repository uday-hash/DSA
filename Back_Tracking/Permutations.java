/*
 * Problem Description
Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= N <= 9


 */

package Back_Tracking;

import java.util.*;

public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        permute(A, 0, result);
        return result;
        
    }

    private void permute(ArrayList<Integer> A, int start, ArrayList<ArrayList<Integer>> result) {
        if (start == A.size()) {
            result.add(new ArrayList<>(A));
            return;
        }
        for (int i = start; i < A.size(); i++) {
            Collections.swap(A, start, i);
            permute(A, start + 1, result);
            Collections.swap(A, start, i);
        }
    }

    


    public static void main(String[] args) {
        Permutations p = new Permutations();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(p.permute(A));
    }
}

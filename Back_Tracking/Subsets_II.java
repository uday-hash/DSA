/*
 * Problem Description
Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.


Problem Constraints
0 <= N <= 16
 */

package Back_Tracking;

import java.util.*;

public class Subsets_II {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        A.sort(null);
        subsets(A, result, current, 0);
        return result;
    }

    public void subsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int i) {
        result.add(new ArrayList<Integer>(current));
        for (int j = i; j < A.size(); j++) {
            if (j > i && A.get(j) == A.get(j - 1)) {
                continue;
            }
            current.add(A.get(j));
            subsets(A, result, current, j + 1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets_II s = new Subsets_II();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(2);
        System.out.println(s.subsetsWithDup(A));
    }
}

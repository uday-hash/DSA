/*
 * Problem Description
Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX
 */

package Back_Tracking;

import java.util.ArrayList;

public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        A.sort(null);
        subsets(A, result, current, 0);
        return result;
    }
    
    public void subsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int i) {
        result.add(new ArrayList<Integer>(current));
        for (int j = i; j < A.size(); j++) {
            current.add(A.get(j));
            subsets(A, result, current, j + 1);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Subset s = new Subset();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(s.subsets(A));
    }
}
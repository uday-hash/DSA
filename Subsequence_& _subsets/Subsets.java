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

package Subsequence_&_subsets;

import java.util.ArrayList;
import java.util.Collections;



public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subsets(A, res, temp, 0);
        return res;
    }
    public void subsets(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int index) {
        res.add(new ArrayList<>(temp));
        for(int i = index; i < A.size(); i++) {
            temp.add(A.get(i));
            subsets(A, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public static void main(String[] args) {
        Subsets obj = new Subsets();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        System.out.println(obj.subsets(A));
    }
    
}

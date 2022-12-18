/*
 * Problem Description
Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.

Each number in A may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
Warning:

DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.

Example : itertools.combinations in python. If you do, we will disqualify your submission and give you penalty points.



Problem Constraints
1 <= N <= 20


 */
package Back_Tracking;

import java.util.*;

public class Combination_sum_II {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        A.sort(null);
        combinationSum(A, result, current, 0, B);
        return result;
    }

    public void combinationSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int i, int B) {
        if (B == 0) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        for (int j = i; j < A.size(); j++) {
            if (j > i && A.get(j) == A.get(j - 1)) {
                continue;
            }
            if (B - A.get(j) < 0) {
                break;
            }
            current.add(A.get(j));
            combinationSum(A, result, current, j + 1, B - A.get(j));
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_sum_II solution = new Combination_sum_II();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(10);
        A.add(1);
        A.add(2);
        A.add(7);
        A.add(6);
        A.add(1);
        A.add(5);
        System.out.println(solution.combinationSum(A, 8));
    }
    
}

/*
 * Problem Description
Given an array of candidate numbers A and a target number B, find all unique combinations in A where the candidate numbers sums to B.

The same repeated number may be chosen from A unlimited number of times.

Note:

1) All numbers (including target) will be positive integers.

2) Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).

3) The combinations themselves must be sorted in ascending order.

4) CombinationA > CombinationB iff (a1 > b1) OR (a1 = b1 AND a2 > b2) OR ... (a1 = b1 AND a2 = b2 AND ... ai = bi AND ai+1 > bi+1)

5) The solution set must not contain duplicate combinations.



Problem Constraints
1 <= |A| <= 20

1 <= A[i] <= 50

1 <= B <= 500
 */


package Back_Tracking;

import java.util.*;

public class Combination_sum {
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
            combinationSum(A, result, current, j, B - A.get(j));
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination_sum s = new Combination_sum();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(8);
        A.add(10);
        A.add(6);
        A.add(11);
        A.add(1);
        A.add(16);
        A.add(8);
        System.out.println(s.combinationSum(A, 28));
    }
}


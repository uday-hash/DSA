/*
Problem Description
Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints
1 <= N <= 106

-107 <= A[i] <= 107
 */

package Hashing;

import java.util.*;

public class Largest_continuous_sequence_zero_sum {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int start = -1;
        int end = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum == 0) {
                start = 0;
                end = i;
                max = Math.max(max, end - start + 1);
            }
            if (map.containsKey(sum)) {
                if (max < i - map.get(sum)) {
                    start = map.get(sum) + 1;
                    end = i;
                    max = Math.max(max, end - start + 1);
                }
            } else
                map.put(sum, i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        if (start == -1)
            return ans;
        for (int i = start; i <= end; i++)
            ans.add(A.get(i));
        return ans;
    }

    public static void main(String[] args) {
        Largest_continuous_sequence_zero_sum obj = new Largest_continuous_sequence_zero_sum();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(-2);
        A.add(4);
        A.add(-4);
        System.out.println(obj.lszero(A));
    }
}
        
    
/*
Problem Description
Given an array A of N integers.

Find the largest continuous sequence in a array which sums to zero.



Problem Constraints
1 <= N <= 106

-107 <= A[i] <= 107
 */

package Hashing;

import java.util.ArrayList;

public class Largest_continuous_sequence_zero_sum {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int maxStart = 0;
        int maxEnd = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            end = i;
            while (sum != 0) {
                sum -= A.get(start);
                start++;
            }
            if (sum == 0 && (end - start) > max) {
                max = end - start;
                maxStart = start;
                maxEnd = end;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = maxStart; i <= maxEnd; i++) {
            ans.add(A.get(i));
        }
        return ans;
    }
}

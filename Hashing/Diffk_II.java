/*
Problem Description
Given an array A of integers and another non negative integer B .

Find if there exists 2 indices i and j such that A[i] - A[j] = B and i != j.



Problem Constraints
1 <= |A| <= 106

0 <= A[i] <= 109

0 <= B <= 109
 */

package Hashing;

import java.util.List;

public class Diffk_II {
    public int diffPossible(final List<Integer> A, int B) {
        int start = 0;
        int end = 0;
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            end = i;
            while (sum > B) {
                sum -= A.get(start);
                start++;
            }
            if (sum == B && start != end) {
                return 1;
            }
        }
        return 0;

    }
}

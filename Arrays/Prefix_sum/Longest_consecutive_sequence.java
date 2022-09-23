/*
Problem Description
Given an unsorted integer array A of size N.

Find the length of the longest set of consecutive elements from array A.



Problem Constraints
1 <= N <= 106

-106 <= A[i] <= 106
 */

package Arrays.Prefix_sum;

import java.util.List;

public class Longest_consecutive_sequence {
    public int longestConsecutive(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
            min = Math.min(min, A.get(i));
        }
        int[] count = new int[max - min + 1];
        for (int i = 0; i < A.size(); i++) {
            count[A.get(i) - min]++;
        }
        int ans = 0;
        int count1 = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                count1++;
            } else {
                ans = Math.max(ans, count1);
                count1 = 0;
            }
        }
        ans = Math.max(ans, count1);
        return ans;
    }
}

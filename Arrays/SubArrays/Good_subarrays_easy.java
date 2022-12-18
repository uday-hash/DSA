/*
 * Problem Description
Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A.


Problem Constraints
1 <= len(A) <= 103
1 <= A[i] <= 103
1 <= B <= 107
 */
package Arrays.SubArrays;

import java.util.*;

public class Good_subarrays_easy {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int[] pre = new int[n];
        pre[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + A.get(i);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = pre[j] - pre[i] + A.get(i);
                if (i == j) {
                    if (sum > B) {
                        count++;
                    }
                } else {
                    if (j - i + 1 % 2 == 0) {
                        if (sum < B) {
                            count++;
                        }
                    } else {
                        if (sum > B) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

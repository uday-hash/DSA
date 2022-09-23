/*
Problem Description
You are given an integer array A of size N.

You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4, and array A contains 10 elements, then

You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103
 */

package Arrays.Prefix_sum;

import java.util.ArrayList;

public class Pick_from_both_sides {
    public int solve(ArrayList<Integer> A, int B) {
        int N = A.size();
        int[] prefix = new int[N];
        int[] suffix = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A.get(i);
            prefix[i] = sum;
        }
        sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += A.get(i);
            suffix[i] = sum;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= B; i++) {
            int left = i - 1 >= 0 ? prefix[i - 1] : 0;
            int right = N - B + i - 1 < N ? suffix[N - B + i] : 0;
            max = Math.max(max, left + right);
        }
        return max;
    }
}

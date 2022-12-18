/*
 * Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000
 */

package Arrays.SubArrays;

import java.util.List;

public class Max_sum_contiguous_subarray {
    public int maxSubArray(final List<Integer> A) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Max_sum_contiguous_subarray obj = new Max_sum_contiguous_subarray();
        System.out.println(obj.maxSubArray(List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
    }
    
    
}

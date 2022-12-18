/*
 * Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000
 */

package Arrays.Advance_Arrays1;

import java.util.ArrayList;
import java.util.List;

public class Max_sum_contiguous_subarray {
    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        int max = A.get(0);
        int sum = A.get(0);
        for(int i = 1; i < n; i++){
            sum = Math.max(A.get(i), sum + A.get(i));
            max = Math.max(max, sum);
        }
        return max;
    }
    public static void main(String[] args) {
        Max_sum_contiguous_subarray obj = new Max_sum_contiguous_subarray();
        List<Integer> A = new ArrayList<>();
        A.add(-2);
        A.add(1);
        A.add(-3);
        A.add(4);
        A.add(-1);
        A.add(2);
        A.add(1);
        A.add(-5);
        A.add(4);
        System.out.println(obj.maxSubArray(A));
    }
    
}

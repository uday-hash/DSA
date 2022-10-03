/*
 * Problem Description
You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.



Problem Constraints
1 <= N <= 105
1 <= Ai <= 10 4

 */

package Arrays.SubArrays;

import java.util.*;


public class Sum_of_all_subarrays {
    public Long subarraySum(ArrayList<Integer> A) {
        long sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += (long) A.get(i) * (i + 1) * (A.size() - i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Sum_of_all_subarrays obj = new Sum_of_all_subarrays();
        System.out.println(obj.subarraySum(new ArrayList<>(List.of(1, 2, 3))));
    }
}

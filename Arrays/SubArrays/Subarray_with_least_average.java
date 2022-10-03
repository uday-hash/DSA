/*
 * Problem Description
Given an array of size N, find the subarray of size K with the least average.



Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5

 */

package Arrays.SubArrays;

import java.util.*;

public class Subarray_with_least_average {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }
        int sum = 0;
        int min_sum = Integer.MAX_VALUE;
        int min_index = 0;
        for (int i = 0; i < B; i++) {
            sum = sum + arr[i];
        }
        min_sum = sum;
        for (int i = B; i < n; i++) {
            sum = sum - arr[i - B] + arr[i];
            if (sum < min_sum) {
                min_sum = sum;
                min_index = i - B + 1;
            }
        }
        return min_index;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        Subarray_with_least_average obj = new Subarray_with_least_average();
        System.out.println(obj.solve(A, 3));
    }
}
    
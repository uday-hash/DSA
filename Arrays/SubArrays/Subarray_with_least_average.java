/*
 * Problem Description
Given an array of size N, find the subarray of size K with the least average.



Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5

 */

package Arrays.SubArrays;

import java.util.ArrayList;

public class Subarray_with_least_average {
    public int solve(ArrayList<Integer> A, int B) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < A.size() - B + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + B; j++) {
                sum += A.get(j);
            }
            if (sum < min) {
                min = sum;
                index = i;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        Subarray_with_least_average obj = new Subarray_with_least_average();
        System.out.println(obj.solve(new ArrayList<>(List.of(3, 7, 90, 20, 10, 50, 40)), 3));
    }
    
}

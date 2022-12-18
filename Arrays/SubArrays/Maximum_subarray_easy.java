/*Problem Description
You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.


Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106 */
package Arrays.SubArrays;

import java.util.*;

public class Maximum_subarray_easy {
    public int maxSubarray(int A, int B, ArrayList<Integer> C) {
        int max = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C.get(j);
                if (sum > B) {
                    break;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Maximum_subarray_easy obj = new Maximum_subarray_easy();
        System.out.println(obj.maxSubarray(5, 10, new ArrayList<>(List.of(1, 2, 3, 4, 5))));
    }
}
    
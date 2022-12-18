/*
 * Problem Description
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.



Problem Constraints
1 <= N <= 103

1 <= A[i] <= 1000

1 <= B <= 107
 */
package Arrays.SubArrays;

import java.util.*;

public class Counting_subarrays_easy {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }
        int count = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (j < n) {
            sum = sum + arr[j];
            if (sum < B) {
                count = count + (j - i + 1);
                j++;
            } else {
                while (sum >= B) {
                    sum = sum - arr[i];
                    i++;
                }
                count = count + (j - i + 1);
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        Counting_subarrays_easy obj = new Counting_subarrays_easy();
        System.out.println(obj.solve(A, 10));
    }
}

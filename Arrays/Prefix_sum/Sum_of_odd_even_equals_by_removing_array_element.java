/*
Count ways to make sum of odd and even indexed elements equal by removing an array element
Given an array of integers, count number of ways to make sum of odd indexed elements equal to sum of even indexed elements by removing an array element.
Examples:

Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing
an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.

Problem Constraints
1 <= n <= 105
-105 <= A[i] <= 105

*/

package Arrays.Prefix_sum;

import java.util.*;

public class Sum_of_odd_even_equals_by_removing_array_element {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + A.get(i - 1);
        }
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + A.get(i);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (prefix[i - 1] == suffix[i + 1]) {
                count++;
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
        Sum_of_odd_even_equals_by_removing_array_element obj = new Sum_of_odd_even_equals_by_removing_array_element();
        System.out.println(obj.solve(A));
    }
}

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

public class Sum_of_odd_even_equals_by_removing_array_element {
    public int solve(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = A[0];
        right[n-1] = A[n-1];
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + A[i];
        }
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + A[i];
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(left[i] == right[i]){
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        Sum_of_odd_even_equals_by_removing_array_element obj = new Sum_of_odd_even_equals_by_removing_array_element();
        int[] A = {1,2,3,4,5};
        System.out.println(obj.solve(A));
    }
}

/*
Problem Description
Given an integer array A of size N. In one second, you can increase the value of one element by 1.

Find the minimum time in seconds to make all elements of the array equal.


Problem Constraints
1 <= N <= 1000000
1 <= A[i] <= 1000
 */

package Arrays.Prefix_sum;

import java.util.*;

public class Time_to_equality {

    public int solve(ArrayList<Integer> A) {

        int n = A.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = A.get(i);
        }
        Arrays.sort(arr);
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        int time = 0;
        for (int i = n - 1; i > 0; i--) {
            time = time + (i * (arr[i] - arr[i - 1]));
        }
        return time;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        Time_to_equality obj = new Time_to_equality();
        System.out.println(obj.solve(A));
    }

}

    
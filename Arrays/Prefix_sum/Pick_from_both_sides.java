/*
Problem Description
You are given an integer array A of size N.

You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from the right end of array A to get the maximum sum.

Find and return this maximum possible sum.

NOTE: Suppose B = 4, and array A contains 10 elements, then

You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back, etc. You need to return the maximum possible sum of elements you can pick.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103
 */

package Arrays.Prefix_sum;

import java.util.*;

public class Pick_from_both_sides {
    public int solve(ArrayList<Integer> A, int B) {
        if (B >= A.size()) {
            int sum = 0;
            for (int i = 0; i < A.size(); i++) {
                sum = sum + A.get(i);
            }
            return sum;
        }
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum = sum + A.get(i);
        }
        int max = sum;
        int i = B - 1;
        int j = A.size() - 1;
        while (i >= 0) {
            sum = sum - A.get(i) + A.get(j);
            if (sum > max) {
                max = sum;
            }
            i--;
            j--;
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(5);
        A.add(-2);
        A.add(3);
        A.add(1);
        A.add(2);
        Pick_from_both_sides obj = new Pick_from_both_sides();
        System.out.println(obj.solve(A, 3));
        
    }
}

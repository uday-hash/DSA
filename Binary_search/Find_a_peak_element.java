/*
 * Problem Description
Given an array of integers A, find and return the peak element in it. 
An array element is peak if it is NOT smaller than its neighbors.

For corner elements, we need to consider only one neighbor. 
We ensure that answer will be unique.

NOTE: Users are expected to solve this in O(log(N)) time. 
The array may have duplicate elements.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109
 */
package Binary_search;

import java.util.ArrayList;

public class Find_a_peak_element {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (mid == 0) {
                if (A.get(mid) > A.get(mid + 1)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            } else if (mid == n - 1) {
                if (A.get(mid) > A.get(mid - 1)) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            } else {
                if (A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                    return mid;
                } else if (A.get(mid) > A.get(mid - 1)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}

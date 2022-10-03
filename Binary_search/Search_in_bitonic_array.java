/*
 * Problem Description
Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic sequence in O(logN) time.

NOTE:

A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly decreasing.


Problem Constraints
3 <= N <= 105

1 <= A[i], B <= 108

Given array always contain a bitonic point.

Array A always contain distinct elements.
 */
package Binary_search;

import java.util.ArrayList;

public class Search_in_bitonic_array {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int l = 0, r = n - 1;
        int max = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A.get(mid) > A.get(mid - 1) && A.get(mid) > A.get(mid + 1)) {
                max = mid;
                break;
            }
            if (A.get(mid) > A.get(mid - 1)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = 0;
        r = max;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A.get(mid) == B) {
                return mid;
            }
            if (A.get(mid) < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        l = max;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A.get(mid) == B) {
                return mid;
            }
            if (A.get(mid) > B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Search_in_bitonic_array obj = new Search_in_bitonic_array();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(9);
        A.add(10);
        A.add(20);
        A.add(17);
        A.add(5);
        A.add(1);
        System.out.println(obj.solve(A, 20));
    }
}
        
    
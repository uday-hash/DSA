/*
 * Problem Description
Given a sorted array of integers A of size N and an integer B.

array A is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).

You are given a target value B to search. If found in the array, 
return its index otherwise, return -1.

You may assume no duplicate exists in the array.

NOTE: Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 1000000

1 <= A[i] <= 10^9

all elements in A are distinct.
 */
package Binary_search;

import java.util.ArrayList;
import java.util.List;

public class Rotated_sorted_array_search {
    public int search(final List<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) < A.get(high)) {
                if (A.get(mid) < B && B <= A.get(high)) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (A.get(low) <= B && B < A.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Rotated_sorted_array_search r = new Rotated_sorted_array_search();
        List<Integer> A = new ArrayList<Integer>();
        A.add(4);
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(0);
        A.add(1);
        A.add(2);
        System.out.println(r.search(A, 4));
        System.out.println(r.search(A, 3));
        System.out.println(r.search(A, 0));
        System.out.println(r.search(A, 2));
    }
}


/*
 * Problem Description
Given a sorted array A of size N and a target value B, return the index (0-based indexing) if the target is found.
If not, return the index where it would be if it were inserted in order.

NOTE: You may assume no duplicates in the array. Users are expected to solve this in O(log(N)) time.



Problem Constraints
1 <= N <= 106
 */
package Binary_search;

import java.util.ArrayList;

public class Sorted_insert_position {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int low = 0, high = A.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
        
    }
    public static void main(String[] args) {
        Sorted_insert_position s = new Sorted_insert_position();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(3);
        A.add(5);
        A.add(6);
        System.out.println(s.searchInsert(A, 5));
        System.out.println(s.searchInsert(A, 2));
        System.out.println(s.searchInsert(A, 7));
        System.out.println(s.searchInsert(A, 0));
    }
    
}

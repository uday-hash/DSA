/*
 * Problem Description
Given an array of integers A of size N and an integer B.

The College library has N books. The ith book has A[i] number of pages.

You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.

A book will be allocated to exactly one student.
Each student has to be allocated at least one book.
Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
Calculate and return that minimum possible number.

NOTE: Return -1 if a valid assignment is not possible.



Problem Constraints
1 <= N <= 105
1 <= A[i], B <= 105
 */
package Binary_search;

import java.util.ArrayList;

public class Allocate_books {
    public int books(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (n < B) {
            return -1;
        }
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            high += A.get(i);
            low = Math.max(low, A.get(i));
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(A, B, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(ArrayList<Integer> A, int B, int mid) {
        int n = A.size();
        int sum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            sum += A.get(i);
            if (sum > mid) {
                count++;
                if (count > B) {
                    return false;
                }
                sum = A.get(i);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(12);
        A.add(34);
        A.add(67);
        A.add(90);
        int B = 2;
        System.out.println(new Allocate_books().books(A, B));
    }
}


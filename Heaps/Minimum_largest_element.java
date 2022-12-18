/*
 * Problem Description
Given an array A of N numbers, you have to perform B operations. 
In each operation, you have to pick any one of the N elements and
 add the original value(value stored at the index before we did any
  operations) to its current value. You can choose any of the N elements
   in each operation.

Perform B operations in such a way that the largest element of the
 modified array(after B operations) is minimized.
Find the minimum possible largest element after B operations.



Problem Constraints
1 <= N <= 106
0 <= B <= 105
-105 <= A[i] <= 105
 */

package Heaps;

import java.util.*;

public class Minimum_largest_element {
    public int solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            maxHeap.add(A.get(i));
        }
        for (int i = 0; i < B; i++) {
            int max = maxHeap.poll();
            maxHeap.add(max + A.get(maxHeap.size()));
        }
        return maxHeap.peek();
        
    }

    public static void main(String[] args) {
        Minimum_largest_element mle = new Minimum_largest_element();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(mle.solve(A, 3));
    }
}

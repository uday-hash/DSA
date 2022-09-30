/*Problem Description
You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
The Median is the middle element in the sorted list of elements. If the number of elements is even then the median will be (sum of both middle elements) / 2.

Return 1 if the array is special else return 0.

NOTE:

For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]


Problem Constraints
1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.


*/

package Heaps;

import java.util.*;

public class Special_median {
    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if (minHeap.size() == 0 || minHeap.peek() > A.get(i)) {
                maxHeap.add(A.get(i));
            } else {
                minHeap.add(A.get(i));
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
            if (i > 0) {
                if (A.get(i) == maxHeap.peek()) {
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Special_median sm = new Special_median();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(4);
        A.add(3);
        System.out.println(sm.solve(A));
    }
}
    }
}

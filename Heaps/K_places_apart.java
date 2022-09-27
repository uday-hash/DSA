/*
 * Problem Description
N people having different priorities are standing in a queue.

The queue follows the property that each person is standing at most B places away from its position in the sorted queue.

Your task is to sort the queue in the increasing order of priorities.

NOTE:

No two persons can have the same priority.
Use the property of the queue to sort the queue with complexity O(NlogB).


Problem Constraints
1 <= N <= 100000
0 <= B <= N
 */
package Heaps;

import java.util.*;

public class K_places_apart {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            minHeap.add(A.get(i));
        }
        for (int i = 0; i < A.size(); i++) {
            C.add(minHeap.poll());
        }
        return C;
    }
    public static void main(String[] args) {
        K_places_apart kpa = new K_places_apart();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(4);
        int B = 3;
        ArrayList<Integer> C = kpa.solve(A, B);
        for (int i = 0; i < C.size(); i++) {
            System.out.print(C.get(i) + " ");
        }
    }
}

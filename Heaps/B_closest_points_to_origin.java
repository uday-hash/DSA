/*
 * Problem Description
We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).

Here, the distance between two points on a plane is the Euclidean distance.

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)

NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).



Problem Constraints
1 <= B <= length of the list A <= 105
-105 <= A[i][0] <= 105
-105 <= A[i][1] <= 105


 */

package Heaps;

import java.util.*;

public class B_closest_points_to_origin {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return (o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1)) - (o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1));
            }
        });
        for (int i = 0; i < A.size(); i++) {
            pq.add(A.get(i));
            if (pq.size() > B) {
                pq.poll();
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        B_closest_points_to_origin bc = new B_closest_points_to_origin();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        A.add(a);
        a = new ArrayList<>();
        a.add(-2);
        a.add(2);
        A.add(a);
        System.out.println(bc.solve(A, 1));
    }
}

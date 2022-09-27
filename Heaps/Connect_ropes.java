/*
 * Problem Description
You are given an array A of integers that represent the lengths of ropes.

You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.

Find and return the minimum cost to connect these ropes into one rope.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 1000
 */
package Heaps;

import java.util.*;

public class Connect_ropes {
    public int solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            pq.add(A.get(i));
        }
        int cost = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            cost += a + b;
            pq.add(a + b);
        }
        return cost;
    }

    public static void main(String[] args) {
        Connect_ropes cr = new Connect_ropes();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(cr.solve(A));
    }
}

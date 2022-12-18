/*
 * Problem Description
Given a sorted array of integers A which contains 1 and some number of primes.
Then, for every p < q in the list, we consider the fraction p / q.

What is the B-th smallest fraction considered?

Return your answer as an array of integers, where answer[0] = p and answer[1] = q.



Problem Constraints
1 <= length(A) <= 2000
1 <= A[i] <= 30000
1 <= B <= length(A)*(length(A) - 1)/2
 */
package Heaps;

import java.util.*;

public class Bth_smallest_prime_fraction {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return A.get(o1.get(0)) * A.get(o2.get(1)) - A.get(o2.get(0)) * A.get(o1.get(1));
            }
        });
        for (int i = 0; i < A.size() - 1; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(i);
            temp.add(A.size() - 1);
            pq.add(temp);
        }
        while (B > 1) {
            ArrayList<Integer> temp = pq.poll();
            if (temp.get(1) - 1 > temp.get(0)) {
                temp.set(1, temp.get(1) - 1);
                pq.add(temp);
            }
            B--;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(A.get(pq.peek().get(0)));
        ans.add(A.get(pq.peek().get(1)));
        return ans;
    }

    public static void main(String[] args) {
        Bth_smallest_prime_fraction bs = new Bth_smallest_prime_fraction();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(5);
        System.out.println(bs.solve(A, 3));
    }
}

/*
 * Problem Description
Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that the kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7


Problem Constraints
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105


 */

package Heaps;

import java.util.*;

public class Magicians_and_chocolates {
    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < B.size(); i++) {
            pq.add(B.get(i));
        }
        long sum = 0;
        while (A > 0) {
            int max = pq.poll();
            sum += max;
            pq.add(max / 2);
            A--;
        }
        return (int) (sum % 1000000007);
    }
    public static void main(String[] args) {
        Magicians_and_chocolates mc = new Magicians_and_chocolates();
        ArrayList<Integer> B = new ArrayList<>();
        B.add(2147483647);
        B.add(2000000014);
        B.add(2147483647);
        System.out.println(mc.nchoc(10, B));
    }
}




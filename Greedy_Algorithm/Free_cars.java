/*Problem Description
Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.

B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.

Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.

NOTE:

You can start buying from time = 0.
Return your answer modulo 109 + 7.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109
0 <= B[i] <= 109 */
package Greedy_Algorithm;

import java.util.*;

public class Free_cars {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int[][] cars = new int[A.size()][2];
        for (int i = 0; i < A.size(); i++) {
            cars[i][0] = A.get(i);
            cars[i][1] = B.get(i);
        }
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        long profit = 0;
        int i = 0;
        while (i < cars.length || !pq.isEmpty()) {
            if (i < cars.length && time < cars[i][0]) {
                time++;
            } else if (i < cars.length && time == cars[i][0]) {
                pq.add(cars[i][1]);
                i++;
            } else {
                profit += pq.poll();
                time++;
            }
        }
        return (int) (profit % 1000000007);
    }
    public static void main(String[] args) {
        Free_cars fc = new Free_cars();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(3);
        B.add(4);
        B.add(5);
        B.add(6);
        B.add(7);
        System.out.println(fc.solve(A, B));
    }
}
    }
}

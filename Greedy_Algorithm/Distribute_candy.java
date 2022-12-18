/*
 * Problem Description
N children are standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum number of candies you must give?



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109
 */
package Greedy_Algorithm;

import java.util.*;

public class Distribute_candy {
    public int candy(ArrayList<Integer> A) {
        int[] candies = new int[A.size()];
        Arrays.fill(candies, 1);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Distribute_candy dc = new Distribute_candy();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(5);
        A.add(2);
        A.add(1);
        System.out.println(dc.candy(A));
    }
}

/*
 * Problem Description
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9
 */
package Hashing;

import java.util.*;

public class Pairs_with_given_sum_II {
    public int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        int mod = 1000000007;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(B - A.get(i)))
                count = (count + map.get(B - A.get(i))) % mod;
            if (map.containsKey(A.get(i)))
                map.put(A.get(i), map.get(A.get(i)) + 1);
            else
                map.put(A.get(i), 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Pairs_with_given_sum_II obj = new Pairs_with_given_sum_II();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(1);
        System.out.println(obj.solve(A, 2));
    }
}
       


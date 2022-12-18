/*
 * Problem Description
Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.

Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.



Problem Constraints
1 <= |A| <= 105
 */
package Hashing;

import java.util.*;

public class Shaggy_and_distances {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                int temp = i - map.get(A.get(i));
                if (temp < min)
                    min = temp;
            }
            map.put(A.get(i), i);
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }
    public static void main(String[] args) {
        Shaggy_and_distances obj = new Shaggy_and_distances();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(obj.solve(A));
    }
}
/*
 * Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9
 */
package Hashing;

import java.util.*;

public class Sub_array_with_0_sum {
    public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum == 0)
                return 1;
            if (map.containsKey(sum))
                return 1;
            else
                map.put(sum, i);
        }
        return 0;
    }

    public static void main(String[] args) {
        Sub_array_with_0_sum obj = new Sub_array_with_0_sum();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(-2);
        A.add(4);
        A.add(-4);
        System.out.println(obj.solve(A));
    }


    

}  

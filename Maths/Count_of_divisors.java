/*
 * Problem Description
Given an array of integers A, find and return the count of divisors of each element of the array.

NOTE: The order of the resultant array should be the same as the input array.



Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 106


 */

package Maths;

import java.util.ArrayList;

public class Count_of_divisors {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 1; j * j <= A.get(i); j++) {
                if (A.get(i) % j == 0) {
                    if (A.get(i) / j == j) {
                        count++;
                    } else {
                        count += 2;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        Count_of_divisors c = new Count_of_divisors();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(c.solve(A));
    }
}

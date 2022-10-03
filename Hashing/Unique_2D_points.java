/*
 * Problem Description
Given a 2D array A of integer points on a 2D plane. Find and return the number of unique points in the array.
The ith point in the array is (A[i][0], A[i][1])


Problem Constraints
1 <= len(A) <= 105
-109 <= A[i][0], A[i][1] <= 109
 */
package Hashing;

import java.util.*;

public class Unique_2D_points {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++)
            set.add(A.get(i));
        return set.size();
    }

    public static void main(String[] args) {
        Unique_2D_points obj = new Unique_2D_points();
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        A.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        A.add(temp);
        temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(1);
        A.add(temp);
        System.out.println(obj.solve(A));
    }
}
    
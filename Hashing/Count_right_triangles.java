/*
 * Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).



Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109
 */
package Hashing;

import java.util.*;

public class Count_right_triangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, Integer> mapX = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> mapY = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.size(); i++) {
            mapX.put(A.get(i), mapX.getOrDefault(A.get(i), 0) + 1);
            mapY.put(B.get(i), mapY.getOrDefault(B.get(i), 0) + 1);
        }
        long count = 0;
        for (int i = 0; i < A.size(); i++) {
            int x = mapX.get(A.get(i)) - 1;
            int y = mapY.get(B.get(i)) - 1;
            count = (count + x * y) % 1000000007;
        }
        return (int) count;
    }

    public static void main(String[] args) {
        Count_right_triangles obj = new Count_right_triangles();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(1);
        A.add(2);
        A.add(2);
        A.add(3);
        A.add(3);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(1);
        B.add(2);
        B.add(1);
        B.add(2);
        System.out.println(obj.solve(A, B));
    }
}
    
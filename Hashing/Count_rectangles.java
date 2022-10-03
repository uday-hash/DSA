/*
 * Problem Description
Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.



Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109
 */
package Hashing;

import java.util.*;

public class Count_rectangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer, ArrayList<Integer>> mapX = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, ArrayList<Integer>> mapY = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            if (!mapX.containsKey(A.get(i)))
                mapX.put(A.get(i), new ArrayList<Integer>());
            mapX.get(A.get(i)).add(B.get(i));
            if (!mapY.containsKey(B.get(i)))
                mapY.put(B.get(i), new ArrayList<Integer>());
            mapY.get(B.get(i)).add(A.get(i));
        }
        long count = 0;
        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> x = mapX.get(A.get(i));
            ArrayList<Integer> y = mapY.get(B.get(i));
            for (int j = 0; j < x.size(); j++) {
                for (int k = 0; k < y.size(); k++) {
                    if (x.get(j) == B.get(i) || y.get(k) == A.get(i))
                        continue;
                    if (mapX.get(y.get(k)).contains(x.get(j)))
                        count++;
                }
            }
        }
        return (int) (count / 4);
    }
    public static void main(String[] args) {
        Count_rectangles obj = new Count_rectangles();
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

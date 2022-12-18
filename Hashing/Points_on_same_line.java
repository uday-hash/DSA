/*
 * Problem Description
Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.

Find and return the maximum number of points that lie on the same line.



Problem Constraints
1 <= (length of the array A = length of array B) <= 1000

-105 <= A[i], B[i] <= 105
 */
package Hashing;

import java.util.*;

public class Points_on_same_line {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() == 1)
            return 1;
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int sameX = 0;
            int sameY = 0;
            int same = 1;
            for (int j = 0; j < A.size(); j++) {
                if (i == j)
                    continue;
                if (A.get(i) == A.get(j) && B.get(i) == B.get(j))
                    same++;
                else if (A.get(i) == A.get(j))
                    sameX++;
                else if (B.get(i) == B.get(j))
                    sameY++;
                else {
                    double slope = (double) (B.get(i) - B.get(j)) / (A.get(i) - A.get(j));
                    map.put(slope, map.getOrDefault(slope, 0) + 1);
                }
            }
            int temp = Math.max(sameX, sameY);
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                temp = Math.max(temp, entry.getValue());
            }
            temp += same;
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        Points_on_same_line obj = new Points_on_same_line();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(1);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(1);
        B.add(1);
        System.out.println(obj.solve(A, B));
    }
}
    
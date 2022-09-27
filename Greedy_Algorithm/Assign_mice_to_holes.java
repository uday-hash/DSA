/*
 * Problem Description
N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.

The positions of Mice are denoted by array A, and the position of holes is denoted by array B.

A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.

Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.



Problem Constraints
1 <= N <= 105

-109 <= A[i], B[i] <= 109
 */
package Greedy_Algorithm;

import java.util.*;

public class Assign_mice_to_holes {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, Math.abs(A.get(i) - B.get(i)));
        }
        return max;
        
    }
    public static void main(String[] args) {
        Assign_mice_to_holes amt = new Assign_mice_to_holes();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(-10);
        A.add(-79);
        A.add(-79);
        A.add(67);
        A.add(93);
        A.add(-85);
        A.add(-28);
        A.add(-94);
        ArrayList<Integer> B = new ArrayList<>();
        B.add(-2);
        B.add(9);
        B.add(69);
        B.add(25);
        B.add(-31);
        B.add(23);
        B.add(50);
        B.add(78);
        System.out.println(amt.mice(A, B));
    }
}

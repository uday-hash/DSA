
/*
 * Problem Description

Given a grid A, a rat is at position (1, 1). He wants to go to the position (n, n) where n is size of the square matrix A.

1 represents a traversable cell and 0 represents a non-traversable cell. Rat can only move right or down.

Return a path that the rat can take.



Problem Constraints

1 <= |A| <= 4
 */
package Back_Tracking;

import java.util.*;

public class Rat_in_maze {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(1);
        path.add(1);
        ans.add(path);
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(0);
        A.add(row1);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        A.add(row2);
        Rat_in_maze obj = new Rat_in_maze();
        System.out.println(obj.solve(A));
    }
}

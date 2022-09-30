/*
 * Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2
 */
package Graphs;

import java.util.*;

public class Rotten_oranges {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        Queue<ArrayList<Integer>> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 2) {
                    q.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                ArrayList<Integer> node = q.poll();
                int x = node.get(0);
                int y = node.get(1);
                if (x > 0 && A.get(x - 1).get(y) == 1) {
                    A.get(x - 1).set(y, 2);
                    q.add(new ArrayList<>(Arrays.asList(x - 1, y)));
                }
                if (x < n - 1 && A.get(x + 1).get(y) == 1) {
                    A.get(x + 1).set(y, 2);
                    q.add(new ArrayList<>(Arrays.asList(x + 1, y)));
                }
                if (y > 0 && A.get(x).get(y - 1) == 1) {
                    A.get(x).set(y - 1, 2);
                    q.add(new ArrayList<>(Arrays.asList(x, y - 1)));
                }
                if (y < m - 1 && A.get(x).get(y + 1) == 1) {
                    A.get(x).set(y + 1, 2);
                    q.add(new ArrayList<>(Arrays.asList(x, y + 1)));
                }
            }
            if (!q.isEmpty()) {
                ans++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Rotten_oranges obj = new Rotten_oranges();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(2, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 1, 0)));
        A.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        System.out.println(obj.solve(A));
    }
}
    
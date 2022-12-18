/*
 * Problem Description
Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is marked as 1 and 0 respectively in the grid.



Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1
 */
package Dynamic_Programming;

import java.util.*;

public class Unique_paths_in_grid {
    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (A.get(i).get(0) == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (A.get(0).get(i) == 1) {
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (A.get(i).get(j) == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        A.add(new ArrayList<>(Arrays.asList(0, 1, 0)));
        A.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        System.out.println(new Unique_paths_in_grid().uniquePathsWithObstacles(A));
    }
}

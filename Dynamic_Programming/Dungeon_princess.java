/*
 * Problem Description
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.



Problem Constraints
1 <= M, N <= 500

-100 <= A[i] <= 100
 */
package Dynamic_Programming;

import java.util.*;

public class Dungeon_princess {
    public int calculateMinimumHP(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = A.get(m-1).get(n-1)>0?1:Math.abs(A.get(m-1).get(n-1))+1;
        for(int i=m-2;i>=0;i--){
            dp[i][n-1] = Math.max(dp[i+1][n-1]-A.get(i).get(n-1),1);
        }
        for(int j=n-2;j>=0;j--){
            dp[m-1][j] = Math.max(dp[m-1][j+1]-A.get(m-1).get(j),1);
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1])-A.get(i).get(j),1);
            }
        }
        return dp[0][0];
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(-2,-3,3)));
        A.add(new ArrayList<>(Arrays.asList(-5,-10,1)));
        A.add(new ArrayList<>(Arrays.asList(10,30,-5)));
        System.out.println(new Dungeon_princess().calculateMinimumHP(A));
    }
}
    
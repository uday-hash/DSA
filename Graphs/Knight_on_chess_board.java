/*
 * Problem Description
Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.


The above figure details the movements for a knight ( 8 possibilities ).

If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.

NOTE: A knight cannot go out of the board.



Problem Constraints
1 <= A, B <= 500


 */

package Graphs;

import java.util.*;

public class Knight_on_chess_board {
    public int knight(int A, int B, int C, int D, int E, int F) {
        int[][] dir = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[A][B];
        q.add(new int[]{C-1,D-1});
        vis[C-1][D-1] = true;
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] x = q.poll();
                if(x[0] == E-1 && x[1] == F-1){
                    return level;
                }
                for(int j=0;j<8;j++){
                    int x1 = x[0] + dir[j][0];
                    int y1 = x[1] + dir[j][1];
                    if(x1 >= 0 && y1 >= 0 && x1 < A && y1 < B && !vis[x1][y1]){
                        q.add(new int[]{x1,y1});
                        vis[x1][y1] = true;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        
        
    }
}
    
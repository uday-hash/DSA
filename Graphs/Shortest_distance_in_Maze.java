/*
 * Problem Description
Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.

1 represents a wall in a matrix and 0 represents an empty location in a wall.

There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.

Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.

Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.



Problem Constraints
2 <= N, M <= 100

0 <= A[i] <= 1

0 <= B[i][0], C[i][0] < N

0 <= B[i][1], C[i][1] < M
 */
package Graphs;

import java.util.*;

public class Shortest_distance_in_Maze {
    public int solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] adj = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                adj[i][j] = A.get(i).get(j);
            }
        }
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{B.get(0),B.get(1)});
        dist[B.get(0)][B.get(1)] = 0;
        while(!q.isEmpty()){
            int[] temp = q.poll();
            for(int i=0;i<4;i++){
                int x = temp[0];
                int y = temp[1];
                int count = 0;
                while(x >= 0 && x < n && y >= 0 && y < m && adj[x][y] == 0){
                    x += dir[i][0];
                    y += dir[i][1];
                    count++;
                }
                x -= dir[i][0];
                y -= dir[i][1];
                count--;
                if(dist[temp[0]][temp[1]] + count < dist[x][y]){
                    dist[x][y] = dist[temp[0]][temp[1]] + count;
                    q.add(new int[]{x,y});
                }
            }
        }
        return dist[C.get(0)][C.get(1)] == Integer.MAX_VALUE ? -1 : dist[C.get(0)][C.get(1)];
    }
    
}

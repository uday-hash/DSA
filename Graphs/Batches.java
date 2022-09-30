/*
 * Problem Description

A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.

Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.

All students who know each other are placed in one batch.

Strength of a batch is equal to sum of the strength of all the students in it.

Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.

Find the number of batches selected.

NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.



Problem Constraints

1 <= A <= 105

1 <= M <= 2*105

1 <= B[i] <= 104

1 <= C[i][0], C[i][1] <= A

1 <= D <= 109
 */
package Graphs;

import java.util.*;

public class Batches {
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {
        ArrayList<Integer>[] adj = new ArrayList[A];
        for(int i=0;i<A;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0;i<C.size();i++){
            adj[C.get(i).get(0)-1].add(C.get(i).get(1)-1);
            adj[C.get(i).get(1)-1].add(C.get(i).get(0)-1);
        }
        int count = 0;
        boolean[] visited = new boolean[A];
        for(int i=0;i<A;i++){
            if(visited[i] == false){
                int sum = B.get(i);
                visited[i] = true;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int temp = q.poll();
                    for(int j=0;j<adj[temp].size();j++){
                        if(visited[adj[temp].get(j)] == false){
                            visited[adj[temp].get(j)] = true;
                            sum += B.get(adj[temp].get(j));
                            q.add(adj[temp].get(j));
                        }
                    }
                }
                if(sum >= D){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Batches obj = new Batches();
        int A = 5;
        ArrayList<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(5);
        ArrayList<ArrayList<Integer>> C = new ArrayList<>();
        C.add(new ArrayList<>(Arrays.asList(1,2)));
        C.add(new ArrayList<>(Arrays.asList(2,3)));
        C.add(new ArrayList<>(Arrays.asList(3,4)));
        C.add(new ArrayList<>(Arrays.asList(4,5)));
        C.add(new ArrayList<>(Arrays.asList(1,5)));
        int D = 10;
        System.out.println(obj.solve(A, B, C, D));
    }
}
    
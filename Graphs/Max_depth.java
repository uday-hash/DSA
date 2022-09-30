/*
 * Problem Description

Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

NOTE:

Level and Depth of the root is considered as 0.
It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
Please read the input format for more clarification.


Problem Constraints

2 <= A, Q(size of array E and F) <= 105

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 106
 */
package Graphs;

import java.util.*;

public class Max_depth {
    public ArrayList<Integer> solve(int A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<A-1;i++){
            adj.get(B.get(i)-1).add(C.get(i)-1);
            adj.get(C.get(i)-1).add(B.get(i)-1);
        }
        int[] depth = new int[A];
        depth[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i=0;i<adj.get(x).size();i++){
                if(depth[adj.get(x).get(i)] == 0){
                    depth[adj.get(x).get(i)] = depth[x] + 1;
                    q.add(adj.get(x).get(i));
                }
            }
        }
        int max = 0;
        for(int i=0;i<A;i++){
            max = Math.max(max,depth[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<E.size();i++){
            int l = E.get(i);
            int x = F.get(i);
            int level = l % (max+1);
            int min = Integer.MAX_VALUE;
            for(int j=0;j<A;j++){
                if(depth[j] == level){
                    if(D.get(j) >= x){
                        min = Math.min(min,D.get(j));
                    }
                }
            }
            if(min == Integer.MAX_VALUE){
                ans.add(-1);
            }else{
                ans.add(min);
            }
        }
        return ans;  
        
    }
}

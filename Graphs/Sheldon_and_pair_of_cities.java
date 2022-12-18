/*
 * Problem Description
Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.

Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the cities and F[i] denotes the distance between the cities.

Now he has many lectures to give in the city and is running short of time, so he asked you C queries, for each query i, find the shortest distance between city G[i] and H[i].

If the two cities are not connected then the distance between them is assumed to be -1.



Problem Constraints
1 <= A <= 200

1 <= B <= 200000

1 <= C <= 100000

1 <= F[i] <= 1000000

1 <= D[i], E[i], G[i], H[i] <= A
 */
package Graphs;

import java.util.*;


public class Sheldon_and_pair_of_cities {
    public ArrayList<Integer> solve(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F, ArrayList<Integer> G, ArrayList<Integer> H) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<A;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<B;i++){
            adj.get(D.get(i)-1).add(E.get(i)-1);
            adj.get(E.get(i)-1).add(D.get(i)-1);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A;i++){
            map.put(i,Integer.MAX_VALUE);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<C;i++){
            int s = G.get(i)-1;
            int d = H.get(i)-1;
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            map.put(s,0);
            while(!q.isEmpty()){
                int x = q.poll();
                for(int j=0;j<adj.get(x).size();j++){
                    if(map.get(adj.get(x).get(j)) == Integer.MAX_VALUE){
                        map.put(adj.get(x).get(j),map.get(x)+1);
                        q.add(adj.get(x).get(j));
                    }
                }
            }
            if(map.get(d) == Integer.MAX_VALUE){
                ans.add(-1);
            }else{
                ans.add(map.get(d));
            }
            map.clear();
            for(int j=0;j<A;j++){
                map.put(j,Integer.MAX_VALUE);
            }
        }
        return ans;
    }
}
    

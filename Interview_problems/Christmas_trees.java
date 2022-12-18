/*
 * Problem Description
You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
The cost of these trees is Bp + Bq + Br.

You are to choose 3 trees such that their total cost is minimum. Return that cost.

If it is not possible to choose 3 such trees return -1.



Problem Constraints
1 <= A[i], B[i] <= 109
3 <= size(A) = size(B) <= 3000
 */
package Interview_problems;

import java.util.ArrayList;

public class Christmas_trees {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < A.size(); i++){
            for(int j = i+1; j < A.size(); j++){
                if(A.get(j) > A.get(i)){
                    for(int k = j+1; k < A.size(); k++){
                        if(A.get(k) > A.get(j)){
                            int cost = B.get(i) + B.get(j) + B.get(k);
                            if(cost < min){
                                min = cost;
                            }
                        }
                    }
                }
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
        
    }

    public static void main(String[] args) {
        Christmas_trees obj = new Christmas_trees();
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        ArrayList<Integer> B = new ArrayList<Integer>();
        B.add(1);
        B.add(2);
        B.add(3);
        B.add(4);
        B.add(5);
        System.out.println(obj.solve(A, B));
    }
    
}

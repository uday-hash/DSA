/*
 * Problem Description
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.

What is the most number of chunks we could have made?



Problem Constraints
1 <= N <= 100000
0 <= A[i] < N
 */
package Arrays.Advance_Array3;

import java.util.ArrayList;

public class Max_chunks_to_make_sorted {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int max = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,A.get(i));
            if(max==i){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(0);
        A.add(1);
        A.add(3);
        System.out.println(new Max_chunks_to_make_sorted().solve(A));
    }
    
}

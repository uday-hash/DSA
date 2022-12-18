/*
 * Problem Description
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)]. It is allowed to swap any two elements (not necessarily consecutive).

Find the minimum number of swaps required to sort the array in ascending order.



Problem Constraints
1 <= N <= 100000
0 <= A[i] < N
 */

package Arrays.Advance_Array3;

import java.util.ArrayList;

public class Minimum_swaps_2 {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int count = 0;
        for(int i=0;i<n;i++){
            if(A.get(i)!=i){
                int temp = A.get(i);
                A.set(i,A.get(temp));
                A.set(temp,temp);
                count++;
                i--;
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
        System.out.println(new Minimum_swaps_2().solve(A));
    }
}

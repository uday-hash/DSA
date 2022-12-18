/*
 * Problem Description
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

NOTE:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.



Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
 */

package Arrays.Advance_Array2;

import java.util.ArrayList;

public class Equilibrium_index {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = A.get(0);
        right[n-1] = A.get(n-1);
        for(int i=1;i<n;i++){
            left[i] = left[i-1] + A.get(i);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = right[i+1] + A.get(i);
        }
        for(int i=0;i<n;i++){
            if(left[i] == right[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Equilibrium_index obj = new Equilibrium_index();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(obj.solve(A));
    }
}

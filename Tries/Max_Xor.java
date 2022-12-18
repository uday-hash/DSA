/*
 * Problem Description
Given an array of integers A, 
find and return the maximum result of A[i] XOR A[j], 
where i, j are the indexes of the array.



Problem Constraints
1 <= length of the array <= 100000
0 <= A[i] <= 109


 */

// Xor operation

package Tries;

import java.util.ArrayList;

public class Max_Xor {
    public int solve(ArrayList<Integer> A) {
        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                max = Math.max(max, A.get(i) ^ A.get(j));
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Max_Xor mx = new Max_Xor();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        System.out.println(mx.solve(A));
    }
}


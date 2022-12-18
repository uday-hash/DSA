/*
 * Problem Description
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 1-indexed.).



Problem Constraints
1 <= A <= 20

1 <= B <= 2A - 1
 */

package Recursion2;

public class Kth_symbol {
    public int solve(int A, int B) {
        if(A == 1){
            return 0;
        }
        int mid = (int)Math.pow(2, A-1)/2;
        if(B <= mid){
            return solve(A-1, B);
        }
        else{
            return 1 - solve(A-1, B-mid);
        }

    }
    public static void main(String[] args) {
        Kth_symbol obj = new Kth_symbol();
        int A = 3;
        int B = 3;
        System.out.println(obj.solve(A, B));
    }
}

/*
 * Problem Description
Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].

Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

Return the minimum number of multiplications needed to multiply the chain.



Problem Constraints
1 <= length of the array <= 1000
1 <= A[i] <= 100
 */
package Dynamic_Programming;

import java.util.*;

public class Matrix_chain_multiplication {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int[][] dp = new int[n][n];
        for(int i=1;i<n;i++){
            dp[i][i] = 0;
        }
        for(int l=2;l<n;l++){
            for(int i=1;i<n-l+1;i++){
                int j = i+l-1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+A.get(i-1)*A.get(k)*A.get(j));
                }
            }
        }
        return dp[1][n-1];
    }
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(40, 20, 30, 10, 30));
        System.out.println(new Matrix_chain_multiplication().solve(A));
    }
}

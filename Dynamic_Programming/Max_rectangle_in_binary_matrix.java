/*
 * Problem Description
Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.



Problem Constraints
1 <= N, M <= 100
 */
package Dynamic_Programming;

import java.util.*;

public class Max_rectangle_in_binary_matrix {
    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
        int m = A.size();
        int n = A.get(0).size();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A.get(i).get(j)==1){
                    dp[i][j] = 1;
                    if(i>0){
                        dp[i][j] += dp[i-1][j];
                    }
                }
            }
        }
        int max = 0;
        for(int i=0;i<m;i++){
            max = Math.max(max, maxArea(dp[i]));
        }
        return max;
    }

    private int maxArea(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = 0;
            }else{
                left[i] = stack.peek()+1;
            }
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n-1;
            }else{
                right[i] = stack.peek()-1;
            }
            stack.push(i);
        }
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max, arr[i]*(right[i]-left[i]+1));
        }
        return max;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        A.add(a);
        a = new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(1);
        A.add(a);
        a = new ArrayList<>();
        a.add(1);
        a.add(0);
        a.add(0);
        A.add(a);
        System.out.println(new Max_rectangle_in_binary_matrix().maximalRectangle(A));
    }
}

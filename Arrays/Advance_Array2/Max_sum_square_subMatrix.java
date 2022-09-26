/*
 * Problem Description
Given a 2D integer matrix A of size N x N, find a B x B submatrix where B<= N and B>= 1, such that the sum of all the elements in the submatrix is maximum.



Problem Constraints
1 <= N <= 103.

1 <= B <= N

-102 <= A[i][j] <= 102.
 */

package Arrays.Advance_Array2;

import java.util.ArrayList;

public class Max_sum_square_subMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size();
        int[][] prefix = new int[n][n];
        prefix[0][0] = A.get(0).get(0);
        for(int i=1;i<n;i++){
            prefix[0][i] = prefix[0][i-1] + A.get(0).get(i);
        }
        for(int i=1;i<n;i++){
            prefix[i][0] = prefix[i-1][0] + A.get(i).get(0);
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + A.get(i).get(j);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n-B;i++){
            for(int j=0;j<=n-B;j++){
                int sum = prefix[i+B-1][j+B-1];
                if(i>0){
                    sum -= prefix[i-1][j+B-1];
                }
                if(j>0){
                    sum -= prefix[i+B-1][j-1];
                }
                if(i>0 && j>0){
                    sum += prefix[i-1][j-1];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Max_sum_square_subMatrix obj = new Max_sum_square_subMatrix();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        A.add(temp);
        temp = new ArrayList<>();
        temp.add(4);
        temp.add(5);
        temp.add(6);
        A.add(temp);
        temp = new ArrayList<>();
        temp.add(7);
        temp.add(8);
        temp.add(9);
        A.add(temp);
        System.out.println(obj.solve(A,2));
    }
}

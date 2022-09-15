/* 
 * Problem Description
Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.

Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.

NOTE:

Rows are numbered from top to bottom, and columns are numbered from left to right.
Sum may be large, so return the answer mod 109 + 7.


Problem Constraints
1 <= N, M <= 1000
-100000 <= A[i] <= 100000
1 <= Q <= 100000
1 <= B[i] <= D[i] <= N
1 <= C[i] <= E[i] <= M
 */
package Arrays.Advance_Array2;

import java.util.ArrayList;

public class Sub_matrix_sum_queries {
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E) {
        int n = A.size();
        int m = A.get(0).size();
        int[][] prefixSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = A.get(i - 1).get(j - 1) + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            int top = B.get(i);
            int left = C.get(i);
            int bottom = D.get(i);
            int right = E.get(i);
            int sum = prefixSum[bottom][right] - prefixSum[top - 1][right] - prefixSum[bottom][left - 1] + prefixSum[top - 1][left - 1];
            result.add(sum);
        }
        return result;

    }
    public static void main(String[] args) {
        Sub_matrix_sum_queries smsq = new Sub_matrix_sum_queries();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        ArrayList<Integer> D = new ArrayList<>();
        ArrayList<Integer> E = new ArrayList<>();
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
        B.add(1);
        B.add(2);
        C.add(1);
        C.add(2);
        D.add(2);
        D.add(3);
        E.add(2);
        E.add(3);
        System.out.println(smsq.solve(A, B, C, D, E));
    }
}

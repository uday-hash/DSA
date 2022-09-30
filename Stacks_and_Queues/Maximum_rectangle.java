/*
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.

Find the largest rectangle containing only 1's and return its area.

Note: Rows are numbered from top to bottom and columns are numbered from left to right.


Input Format

The only argument given is the integer matrix A.
Output Format

Return the area of the largest rectangle containing only 1's.
Constraints

1 <= N, M <= 1000
0 <= A[i] <= 1

 */
package Stacks_and_Queues;

import java.util.*;

public class Maximum_rectangle {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int maxArea = 0;
        int[] row = new int[A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(i).size(); j++) {
                if (A.get(i).get(j) == 0) {
                    row[j] = 0;
                } else {
                    row[j] += A.get(i).get(j);
                }
            }
            maxArea = Math.max(maxArea, largestRectangleArea(row));
        }
        return maxArea;
    }
    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < A.length) {
            if (stack.isEmpty() || A[stack.peek()] <= A[i]) {
                stack.add(i);
                i++;
            } else {
                int top = stack.pop();
                int area = A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = A[top] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Maximum_rectangle m = new Maximum_rectangle();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(0, 1, 1)));
        A.add(new ArrayList<>(Arrays.asList(1, 0, 0)));
        System.out.println(m.solve(A));
    }
}

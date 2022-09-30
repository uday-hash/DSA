/*
 * Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000000


 */
package Stacks_and_Queues;

import java.util.*;

public class Largest_rectangle_in_histogram {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < A.size()) {
            if (stack.isEmpty() || A.get(stack.peek()) <= A.get(i)) {
                stack.add(i);
                i++;
            } else {
                int top = stack.pop();
                int area = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        Largest_rectangle_in_histogram l = new Largest_rectangle_in_histogram();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        System.out.println(l.largestRectangleArea(A));
    }

}

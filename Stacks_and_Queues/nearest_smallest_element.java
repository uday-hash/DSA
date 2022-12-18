/*
 * Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.
 */
package Stacks_and_Queues;

import java.util.*;

public class nearest_smallest_element {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && stack.peek() >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.add(-1);
            } else {
                result.add(stack.peek());
            }
            stack.push(A.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        nearest_smallest_element n = new nearest_smallest_element();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        System.out.println(n.prevSmaller(A));
    }
}

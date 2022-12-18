/*
 * Problem Description

Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.



Problem Constraints

1 <= number of nodes <= 100000
 */
package BST;

import java.util.ArrayList;

public class Check_for_BST_with_one_child {
    public String solve(ArrayList<Integer> A) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return check(A, min, max, 0) ? "YES" : "NO";
    }

    public boolean check(ArrayList<Integer> A, int min, int max, int index) {
        if(index >= A.size())
            return true;
        if(A.get(index) < min || A.get(index) > max)
            return false;
        return check(A, min, A.get(index) - 1, index + 1) || check(A, A.get(index) + 1, max, index + 1);
    }

    public static void main(String[] args) {
        Check_for_BST_with_one_child c = new Check_for_BST_with_one_child();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(3);
        System.out.println(c.solve(A));
    }
}


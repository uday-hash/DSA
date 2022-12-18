/*
 * Problem Description
Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.

Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side

NOTE: The value comes first in the array which have lower level.

Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109
 */
package Trees.Advance_tress;

import java.util.ArrayList;

public class Left_view_of_Binary_tree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        solve(A, res, 0);
        return res;
    }
    public void solve(TreeNode A, ArrayList<Integer> res, int level) {
        if(A == null)
            return;
        if(level == res.size())
            res.add(A.val);
        solve(A.left, res, level + 1);
        solve(A.right, res, level + 1);
    }
    public static void main(String[] args) {
        Left_view_of_Binary_tree l = new Left_view_of_Binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        ArrayList<Integer> res = l.solve(root);
        for(int i : res)
            System.out.print(i + " ");
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; 
    left=null;
    right=null;
    }
}
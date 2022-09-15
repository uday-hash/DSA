/*
 * Problem Description

You are given the root node of a binary tree A. Each node has a value val and depth depth.

Initially depth of each node is set to -1. You have to fill the depth of each node with its correct value.
Depth of a node T is the number of nodes along the longest path from the root node down to node T. Also, depth of root node is always equal to 1.



Problem Constraints

1 <= Number of nodes <= 105

0 <= Value of each node <= 109

Initially, Depth of each node(depth) is set to -1.


 */

package Trees;

public class Depth_of_each_node {
    static void solve(TreeNode A){
        solve(A, 1);
    }
    static void solve(TreeNode A, int depth){
        if(A == null)
            return;
        A.depth = depth;
        solve(A.left, depth + 1);
        solve(A.right, depth + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        solve(root);
        System.out.println(root.depth);
        System.out.println(root.left.depth);
        System.out.println(root.right.depth);
        System.out.println(root.left.left.depth);
        System.out.println(root.left.right.depth);
        System.out.println(root.right.left.depth);
        System.out.println(root.right.right.depth);
        System.out.println(root.left.left.left.depth);
        System.out.println(root.left.left.right.depth);
        System.out.println(root.left.right.left.depth);
    }
    
}

static public class TreeNode {
    public int depth;
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; this.depth = -1;}
}
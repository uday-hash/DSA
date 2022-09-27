/*
 * Problem Description
Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.

The diameter of a tree is the number of edges on the longest path between two nodes in the tree.



Problem Constraints
0 <= N <= 105


 */
package Trees;

public class Diameter_of_binary_tree {
    public int solve(TreeNode A) {
        int[] max = new int[1];
        height(A, max);
        return max[0];
    }

    public int height(TreeNode A, int[] max) {
        if(A == null)
            return 0;
        int left = height(A.left, max);
        int right = height(A.right, max);
        max[0] = Math.max(max[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        Diameter_of_binary_tree d = new Diameter_of_binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(d.solve(root));
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
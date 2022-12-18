/*
Problem Description
Given two binary trees, check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.



Problem Constraints
1 <= number of nodes <= 105 */

package Trees;

public class Identical_binary_trees {
    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        return isSameTree(A.left, B.left) & isSameTree(A.right, B.right);

    }
    public static void main(String[] args) {
        Identical_binary_trees obj = new Identical_binary_trees();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        TreeNode B = new TreeNode(1);
        B.left = new TreeNode(2);
        B.right = new TreeNode(3);
        System.out.println(obj.isSameTree(A, B));
    }
}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {
    val = x;
    left=null;
    right=null;
    }
}

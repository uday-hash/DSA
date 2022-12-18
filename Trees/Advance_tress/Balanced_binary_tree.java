/*
 * Problem Description
Given a root of binary tree A, determine if it is height-balanced.

A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.



Problem Constraints
1 <= size of tree <= 100000


 */
package Trees.Advance_tress;

public class Balanced_binary_tree {
    public int isBalanced(TreeNode A) {
        if(A == null)
            return 1;
        int left = height(A.left);
        int right = height(A.right);
        if(Math.abs(left - right) > 1)
            return 0;
        return isBalanced(A.left) & isBalanced(A.right);

    }

    public int height(TreeNode A) {
        if(A == null)
            return 0;
        return 1 + Math.max(height(A.left), height(A.right));
    }

    public static void main(String[] args) {
        Balanced_binary_tree b = new Balanced_binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        System.out.println(b.isBalanced(root));
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
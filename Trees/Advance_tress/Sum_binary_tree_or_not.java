/*
 * Problem Description
Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.

Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.

An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.

Return 1 if it sum-binary tree else return 0.



Problem Constraints
1 <= length of the array <= 100000

0 <= node values <= 50
 */

package Trees.Advance_tress;

public class Sum_binary_tree_or_not {
    public int solve(TreeNode A) {
        if(A == null)
            return 1;
        if(A.left == null && A.right == null)
            return 1;
        int left = sum(A.left);
        int right = sum(A.right);
        if(left + right == A.val)
            return 1;
        return 0;
    }

    public int sum(TreeNode A) {
        if(A == null)
            return 0;
        return A.val + sum(A.left) + sum(A.right);
    }

    public static void main(String[] args) {
        Sum_binary_tree_or_not s = new Sum_binary_tree_or_not();
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        System.out.println(s.solve(root));
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
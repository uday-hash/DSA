/*
 * Problem Description
You are given a binary tree represented by root A.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1


 */
package BST;

public class Valid_binary_search_tree {
    public int isValidBST(TreeNode A) {
        return check(A, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int check(TreeNode A, int min, int max) {
        if(A == null)
            return 1;
        if(A.val < min || A.val > max)
            return 0;
        return check(A.left, min, A.val - 1) * check(A.right, A.val + 1, max);
    }

    public static void main(String[] args) {
        Valid_binary_search_tree v = new Valid_binary_search_tree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(v.isValidBST(root));
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
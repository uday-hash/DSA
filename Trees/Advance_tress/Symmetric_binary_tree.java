/*
 * Problem Description
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Problem Constraints
1 <= number of nodes <= 105
 */

package Trees.Advance_tress;

public class Symmetric_binary_tree {
    public int isSymmetric(TreeNode A) {
        return isMirror(A, A) ? 1 : 0;
    }

    public boolean isMirror(TreeNode A, TreeNode B) {
        if(A == null && B == null)
            return true;
        if(A == null || B == null)
            return false;
        return A.val == B.val && isMirror(A.left, B.right) && isMirror(A.right, B.left);
    }

    public static void main(String[] args) {
        Symmetric_binary_tree s = new Symmetric_binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(s.isSymmetric(root));
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
/*
 * Problem Description
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 adding up all the values along the path equals the given sum.



Problem Constraints
1 <= number of nodes <= 105

-100000 <= B, value of nodes <= 100000
 */

package Trees.Advance_tress;

public class Path_sum {
    public int hasPathSum(TreeNode A, int B) {
        if(A == null)
            return 0;
        if(A.left == null && A.right == null && A.val == B)
            return 1;
        return hasPathSum(A.left, B - A.val) | hasPathSum(A.right, B - A.val);
    }

    public static void main(String[] args) {
        Path_sum p = new Path_sum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(p.hasPathSum(root, 10));
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
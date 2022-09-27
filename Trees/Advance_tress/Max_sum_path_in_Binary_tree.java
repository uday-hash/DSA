/*
 * Problem Description
Given a binary tree T, find the maximum path sum.

The path may start and end at any node in the tree.



Problem Constraints
1 <= Number of Nodes <= 7e4

-1000 <= Value of Node in T <= 1000



 */

package Trees.Advance_tress;

public class Max_sum_path_in_Binary_tree {
    public int maxPathSum(TreeNode A) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(A, max);
        return max[0];
    }

    public int maxPathSum(TreeNode A, int[] max) {
        if(A == null)
            return 0;
        int left = maxPathSum(A.left, max);
        int right = maxPathSum(A.right, max);
        int temp = Math.max(Math.max(left, right) + A.val, A.val);
        int ans = Math.max(temp, left + right + A.val);
        max[0] = Math.max(max[0], ans);
        return temp;
    }
    public static void main(String[] args) {
        Max_sum_path_in_Binary_tree m = new Max_sum_path_in_Binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(m.maxPathSum(root));
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
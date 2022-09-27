/*
 * Problem Description
Given a binary search tree of integers. You are given a range B and C.

Return the count of the number of nodes that lie in the given range.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= B < = C <= 109
 */
package BST;

public class BST_nodes_in_a_range {
    public int solve(TreeNode A, int B, int C) {
        if(A == null)
            return 0;
        if(A.val >= B && A.val <= C)
            return 1 + solve(A.left, B, C) + solve(A.right, B, C);
        if(A.val < B)
            return solve(A.right, B, C);
        return solve(A.left, B, C);
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
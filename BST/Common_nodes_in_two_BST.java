/*
 * Problem Description
Given two BST's A and B, return the (sum of all common nodes in both A and B) % 
(109 +7) .

In case there is no common node, return 0.

NOTE:

Try to do it one pass through the trees.



Problem Constraints
1 <= Number of nodes in the tree A and B <= 105

1 <= Node values <= 106


 */
package BST;

public class Common_nodes_in_two_BST {
    public int solve(TreeNode A, TreeNode B) {
        if(A == null || B == null)
            return 0;
        if(A.val == B.val)
            return A.val + solve(A.left, B.left) + solve(A.right, B.right);
        if(A.val < B.val)
            return solve(A.right, B);
        return solve(A, B.right);
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
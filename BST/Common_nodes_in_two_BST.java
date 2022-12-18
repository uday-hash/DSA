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
        int sum = 0;
        TreeNode left = A, right = B;
        while(left.left != null)
            left = left.left;
        while(right.left != null)
            right = right.left;
        while(left != null && right != null) {
            if(left.val == right.val) {
                sum += left.val;
                left = inorderSuccessor(A, left);
                right = inorderSuccessor(B, right);
            }
            else if(left.val < right.val)
                left = inorderSuccessor(A, left);
            else
                right = inorderSuccessor(B, right);
        }
        return sum;
    }

    public TreeNode inorderSuccessor(TreeNode A, TreeNode B) {
        if(B.right != null) {
            B = B.right;
            while(B.left != null)
                B = B.left;
            return B;
        }
        TreeNode succ = null;
        while(A != null) {
            if(B.val < A.val) {
                succ = A;
                A = A.left;
            }
            else if(B.val > A.val)
                A = A.right;
            else
                break;
        }
        return succ;
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
/*Problem Description
Given a binary search tree of integers. You are given a range B and C.

Return the count of the number of nodes that lie in the given range.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= B < = C <= 109 */

package Trees;

public class BST_nodes_in_a_range {
    public int solve(TreeNode A, int B, int C) {
        if (A == null) {
            return 0;
        }
        if (A.val >= B && A.val <= C) {
            return 1 + solve(A.left, B, C) + solve(A.right, B, C);
        } else if (A.val < B) {
            return solve(A.right, B, C);
        } else {
            return solve(A.left, B, C);
        }
    }
    public static void main(String[] args) {
        BST_nodes_in_a_range obj = new BST_nodes_in_a_range();
        TreeNode A = new TreeNode(10);
        A.left = new TreeNode(5);
        A.right = new TreeNode(50);
        A.left.left = new TreeNode(1);
        A.right.left = new TreeNode(40);
        A.right.right = new TreeNode(100);
        System.out.println(obj.solve(A, 5, 45));
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
  


/*
 * Problem Description
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Problem Constraints
1 <= number of nodes <= 105
 */

package Trees;

public class Symmetric_binary_tree {
    public int isSymmetric(TreeNode A) {
        return isMirror(A, A);
    }
    public int isMirror(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        return isMirror(A.left, B.right) & isMirror(A.right, B.left);
    }
    public static void main(String[] args) {
        Symmetric_binary_tree obj = new Symmetric_binary_tree();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(3);
        A.left.right = new TreeNode(4);
        A.right.left = new TreeNode(4);
        A.right.right = new TreeNode(3);
        System.out.println(obj.isSymmetric(A));
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
  

/*Problem Description
You are given the root node of a binary tree A. You have to find the height of the given tree.

A binary tree's height is the number of nodes along the longest path from the root node down to the farthest leaf node.



Problem Constraints
1 <= Number of nodes in the tree <= 105

0 <= Value of each node <= 109 */

package Trees;

public class Tree_height {
    public int solve(TreeNode A) {
        if(A == null)
            return 0;
        return 1 + Math.max(solve(A.left), solve(A.right));
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
     

        Tree_height obj = new Tree_height();
        System.out.println(obj.solve(root));
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

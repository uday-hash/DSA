/*
 * Problem Description
You are given the root node of a binary tree A. You have to find the number of nodes in this tree.



Problem Constraints
1 <= Number of nodes in the tree <= 105

0 <= Value of each node <= 107
 */

 package Trees;

 public class Nodes_count{
    public int solve(TreeNode A) {
        if(A == null)
            return 0;
        return 1 + solve(A.left) + solve(A.right);
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
     

        Nodes_count obj = new Nodes_count();
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
  
/*
 * Problem Description
Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.



Problem Constraints
1 <= Number of Nodes <= 200000

1 <= Value of Nodes <= 2000000000
 */
package Trees;

public class Counting_the_nodes {
    public int solve(TreeNode A) {
        return solve(A, Integer.MIN_VALUE);
    }
    public int solve(TreeNode A, int max) {
        if(A == null)
            return 0;
        if(A.val > max)
            return 1 + solve(A.left, A.val) + solve(A.right, A.val);
        else
            return solve(A.left, max) + solve(A.right, max);
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
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        root.left.left.left.left = new TreeNode(16);
        root.left.left.left.right = new TreeNode(17);
        root.left.left.right.left = new TreeNode(18);
        root.left.left.right.right = new TreeNode(19);
        root.left.right.left.left = new TreeNode(20);

        Counting_the_nodes obj = new Counting_the_nodes();
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
  

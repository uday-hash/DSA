/*
 * Problem Description
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109
 */
package Trees.Advance_tress;

public class Odd_and_even_level {
    public int solve(TreeNode A) {
        if(A == null)
            return 0;
        return A.val - solve(A.left) - solve(A.right);
    }

    public static void main(String[] args) {
        Odd_and_even_level o = new Odd_and_even_level();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(o.solve(root));
    }

}
class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; 
    left=null;
    right=null;
    }
}
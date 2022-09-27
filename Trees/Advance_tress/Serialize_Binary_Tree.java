/*
 * Problem Description
Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.

Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105


 */

package Trees.Advance_tress;

import java.util.ArrayList;

public class Serialize_Binary_Tree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(A);
        ans.add(A.val);
        while(queue.size() > 0) {
            TreeNode curr = queue.get(0);
            queue.remove(0);
            if(curr.left != null) {
                queue.add(curr.left);
                ans.add(curr.left.val);
            } else
                ans.add(-1);
            if(curr.right != null) {
                queue.add(curr.right);
                ans.add(curr.right.val);
            } else
                ans.add(-1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Serialize_Binary_Tree s = new Serialize_Binary_Tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(s.solve(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;
    left = null;
    right = null;
    }
}
/*
 * Problem Description
Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.

Return the nodes in any order.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
 */
package Trees.Advance_tress;

import java.util.ArrayList;

public class Top_view_of_Binary_tree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null)
            return ans;
        ans.add(A.val);
        TreeNode left = A.left;
        while(left != null) {
            ans.add(left.val);
            left = left.left;
        }
        TreeNode right = A.right;
        while(right != null) {
            ans.add(0, right.val);
            right = right.right;
        }
        return ans;
        
    }

    public static void main(String[] args) {
        Top_view_of_Binary_tree t = new Top_view_of_Binary_tree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        System.out.println(t.solve(root));
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
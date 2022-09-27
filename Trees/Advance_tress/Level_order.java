/*
 * Problem Description
Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Problem Constraints
1 <= number of nodes <= 105
 */
package Trees.Advance_tress;

import java.util.ArrayList;

public class Level_order {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        levelOrder(A, res, 0);
        return res;
    }
    public void levelOrder(TreeNode A, ArrayList<ArrayList<Integer>> res, int level) {
        if(A == null)
            return;
        if(level == res.size())
            res.add(new ArrayList<Integer>());
        res.get(level).add(A.val);
        levelOrder(A.left, res, level + 1);
        levelOrder(A.right, res, level + 1);
    }
    public static void main(String[] args) {
        Level_order l = new Level_order();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = l.levelOrder(root);
        for(ArrayList<Integer> a : res) {
            for(int i : a)
                System.out.print(i + " ");
            System.out.println();
        }
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
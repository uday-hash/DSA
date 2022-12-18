/*
 * Problem Description

Given a binary tree, return the reverse level order traversal of its nodes values. (i.e, from left to right and from last level to starting level).



Problem Constraints

1 <= number of nodes <= 5 * 105

1 <= node value <= 105
 */
package Trees.Advance_tress;

import java.util.ArrayList;

public class Reverse_level_order {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        int h = height(A);
        for(int i = h; i >= 1; i--) {
            printGivenLevel(A, i, ans);
        }
        return ans;
    }

    public int height(TreeNode A) {
        if(A == null)
            return 0;
        int lheight = height(A.left);
        int rheight = height(A.right);
        if(lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;
    }

    public void printGivenLevel(TreeNode A, int level, ArrayList<Integer> ans) {
        if(A == null)
            return;
        if(level == 1)
            ans.add(A.val);
        else if(level > 1) {
            printGivenLevel(A.left, level - 1, ans);
            printGivenLevel(A.right, level - 1, ans);
        }
    }

    public static void main(String[] args) {
        Reverse_level_order r = new Reverse_level_order();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(r.solve(root));
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
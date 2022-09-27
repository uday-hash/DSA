/*
 * Problem Description
Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).



Problem Constraints
1 <= number of nodes <= 105



 */
package Trees.Advance_tress;

import java.util.ArrayList;

public class ZigZag_level_order_traversal_BT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int h = height(A);
        for(int i = 1; i <= h; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            printGivenLevel(A, i, temp);
            if(i % 2 == 0)
                reverse(temp);
            ans.add(temp);
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

    public void printGivenLevel(TreeNode A, int level, ArrayList<Integer> temp) {
        if(A == null)
            return;
        if(level == 1)
            temp.add(A.val);
        else if(level > 1) {
            printGivenLevel(A.left, level - 1, temp);
            printGivenLevel(A.right, level - 1, temp);
        }
    }

    public void reverse(ArrayList<Integer> temp) {
        int i = 0, j = temp.size() - 1;
        while(i < j) {
            int t = temp.get(i);
            temp.set(i, temp.get(j));
            temp.set(j, t);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        ZigZag_level_order_traversal_BT z = new ZigZag_level_order_traversal_BT();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(z.zigzagLevelOrder(root));
    }
}
    
class  TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;
    left = null;
    right = null;
    }
}
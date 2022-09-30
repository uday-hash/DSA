/*
 * Problem Description
Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.

NOTE: Consider the level of root node as 1.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 109
 */
package Trees.Advance_tress;

import java.util.*;

public class Odd_and_even_level {
    public int solve(TreeNode A) {
        if(A == null)
            return 0;
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if(level % 2 == 0)
                    sum -= curr.val;
                else
                    sum += curr.val;
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            level++;
        }
        return sum;
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
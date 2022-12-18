/*
 * Problem Description
Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.


NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.



Problem Constraints
0 <= number of nodes <= 105
 */

package Trees.Advance_tress;

import java.util.*;

public class Vertical_order_traversal{
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(A == null)
            return ans;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        q.add(A);
        level.add(0);
        int min = 0;
        int max = 0;
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            int l = level.poll();
            if(!map.containsKey(l))
                map.put(l, new ArrayList<>());
            map.get(l).add(temp.val);
            if(temp.left != null) {
                q.add(temp.left);
                level.add(l-1);
                min = Math.min(min, l-1);
            }
            if(temp.right != null) {
                q.add(temp.right);
                level.add(l+1);
                max = Math.max(max, l+1);
            }
        }
        for(int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Vertical_order_traversal v = new Vertical_order_traversal();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        System.out.println(v.verticalOrderTraversal(root));
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
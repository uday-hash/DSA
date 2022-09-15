/*Problem Description
Given a Binary Tree A containing N nodes, you need to find the path from Root to a given node B.

NOTE:

No two nodes in the tree have the same data values.
You can assume that B is present in tree A and a path always exists. */

package Trees;

import java.util.ArrayList;

public class Path_to_given_node {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> path = new ArrayList<>();
        path.add(A.val);
        if(A.val == B)
            return path;
        if(A.left != null){
            ArrayList<Integer> left = solve(A.left, B);
            if(left.size() > 0){
                path.addAll(left);
                return path;
            }
        }
        if(A.right != null){
            ArrayList<Integer> right = solve(A.right, B);
            if(right.size() > 0){
                path.addAll(right);
                return path;
            }
        }
        path.remove(path.size()-1);
        return path;
        
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

        Path_to_given_node obj = new Path_to_given_node();
        System.out.println(obj.solve(root, 31));
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
  

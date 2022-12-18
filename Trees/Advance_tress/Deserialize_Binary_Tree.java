/*
 * Problem Description
You are given an integer array A denoting the Level Order Traversal of the Binary Tree.

You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.

NOTE:

In the array, the NULL/None child is denoted by -1.
For more clarification check the Example Input.


Problem Constraints
1 <= number of nodes <= 105

-1 <= A[i] <= 105


 */
package Trees.Advance_tress;

import java.util.ArrayList;

public class Deserialize_Binary_Tree {
    public TreeNode solve(ArrayList<Integer> A) {
        if(A.size() == 0)
            return null;
        TreeNode root = new TreeNode(A.get(0));
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        int i = 1;
        while(i < A.size()) {
            TreeNode curr = queue.get(0);
            queue.remove(0);
            if(A.get(i) != -1) {
                curr.left = new TreeNode(A.get(i));
                queue.add(curr.left);
            }
            i++;
            if(i >= A.size())
                break;
            if(A.get(i) != -1) {
                curr.right = new TreeNode(A.get(i));
                queue.add(curr.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args) {
        Deserialize_Binary_Tree d = new Deserialize_Binary_Tree();
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(-1);
        A.add(4);
        A.add(-1);
        A.add(5);
        TreeNode root = d.solve(A);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left);
        System.out.println(root.left.right.val);
        System.out.println(root.right.left);
        System.out.println(root.right.right.val);
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
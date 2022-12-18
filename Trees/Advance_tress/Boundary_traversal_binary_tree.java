/*
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from the root to the left-most node. Right boundary is defined as the path from the root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Return an array of integers denoting the boundary values of tree in anti-clockwise order.
 */

package Trees.Advance_tress;

import java.util.ArrayList;

public class Boundary_traversal_binary_tree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(A == null)
            return ans;
        ans.add(A.val);
        left(A.left, ans);
        leaves(A, ans);
        right(A.right, ans);
        return ans;
    }

    public void left(TreeNode A, ArrayList<Integer> ans) {
        if(A == null)
            return;
        if(A.left != null) {
            ans.add(A.val);
            left(A.left, ans);
        } else if(A.right != null) {
            ans.add(A.val);
            left(A.right, ans);
        }
    }

    public void leaves(TreeNode A, ArrayList<Integer> ans) {
        if(A == null)
            return;
        leaves(A.left, ans);
        if(A.left == null && A.right == null)
            ans.add(A.val);
        leaves(A.right, ans);
    }

    public void right(TreeNode A, ArrayList<Integer> ans) {
        if(A == null)
            return;
        if(A.right != null) {
            right(A.right, ans);
            ans.add(A.val);
        } else if(A.left != null) {
            right(A.left, ans);
            ans.add(A.val);
        }
    }
    public static void main(String[] args) {
        Boundary_traversal_binary_tree b = new Boundary_traversal_binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(b.solve(root));
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
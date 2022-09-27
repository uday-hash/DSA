/*
 * Problem Description
Given a binary tree,

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Assume perfect binary tree and try to solve this in constant extra space.



Problem Constraints
1 <= Number of nodes in binary tree <= 100000

0 <= node values <= 10^9
 */

package Trees.Advance_tress;

public class Next_pointer_Binary_Tree {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null && root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }

    public static void main(String[] args) {
        Next_pointer_Binary_Tree n = new Next_pointer_Binary_Tree();
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        n.connect(root);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
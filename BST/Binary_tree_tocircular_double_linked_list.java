/*
 * Problem Description
Given a binary tree convert it into circular doubly linked list based on the following rules:

The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
The order of nodes in List must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal must be the head node of the Circular List.
NOTE: You are expected to convert the binary tree into Doubly linked list in place.



Problem Constraints
1 <= Number of nodes in tree <= 100000

1 <= Value of node <= 109
 */
package BST;

public class Binary_tree_tocircular_double_linked_list {
    public TreeNode solve(TreeNode root) {
        if(root == null)
            return null;
        TreeNode head = null;
        TreeNode prev = null;
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                if(head == null)
                    head = curr;
                if(prev != null) {
                    prev.right = curr;
                    curr.left = prev;
                }
                prev = curr;
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr)
                    temp = temp.right;
                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                } else {
                    temp.right = null;
                    prev.right = curr;
                    curr.left = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        prev.right = head;
        head.left = prev;
        return head;
    }

    public static void main(String[] args) {
        Binary_tree_tocircular_double_linked_list b = new Binary_tree_tocircular_double_linked_list();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        TreeNode head = b.solve(root);
        TreeNode curr = head;
        while(curr.right != head) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
        System.out.print(curr.val);
    }
        
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;
    left = right = null;
    }
}
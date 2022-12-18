/*
 * Problem Description
Given a linked list where every node represents a linked list and contains two pointers of its type:

Pointer to next node in the main list (right pointer)
Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.



Problem Constraints
1 <= Total nodes in the list <= 100000

1 <= Value of node <= 109
 */

package Doubled_linked_list;

public class Flatten_a_linked_list {
    ListNode flatten(ListNode root) {
        if (root == null || root.right == null) {
            return root;
        }
        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;

    }

    ListNode merge(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode result;
        if (a.val < b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }
        result.right = null;
        return result;
    }

}

class ListNode {
    int val;
    ListNode right, down;

    ListNode(int x) {
        val = x;
        right = down = null;
    }
}
/*
 * Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000
 */

package LinkedList.Advance;

public class Remove_loop_from_linked_list {
    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return A;
        }
        slow = A;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
        return A;
    }
    
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
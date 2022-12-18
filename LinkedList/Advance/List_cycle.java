/*
 * Problem Description

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.
 */
package LinkedList.Advance;

//import java.util.*;

public class List_cycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a;
        ListNode fast = a;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = a;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    
	}
    
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
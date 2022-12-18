/*
 * Problem Description
Given a singly linked list A

 A: A0 → A1 → … → An-1 → An 
reorder it to:

 A0 → An → A1 → An-1 → A2 → An-2 → … 
You must do this in-place without altering the nodes' values.



Problem Constraints
1 <= |A| <= 106
 */
package LinkedList.Advance;

public class Reorder_list {
    public ListNode reorderList(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head = slow.next;
        slow.next = null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        ListNode newHead = new ListNode(0);
        ListNode curr1 = A;
        ListNode curr2 = head;
        ListNode curr3 = newHead;
        while (curr1 != null && curr2 != null) {
            curr3.next = curr1;
            curr1 = curr1.next;
            curr3 = curr3.next;
            curr3.next = curr2;
            curr2 = curr2.next;
            curr3 = curr3.next;
        }
        if (curr1 != null) {
            curr3.next = curr1;
        }
        if (curr2 != null) {
            curr3.next = curr2;
        }
        return newHead.next;
        
    }

    public static void main(String[] args) {
        Reorder_list r = new Reorder_list();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = r.reorderList(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
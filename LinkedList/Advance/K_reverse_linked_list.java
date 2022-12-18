/*
 * Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.



Problem Constraints
1 <= |A| <= 103

B always divides A
 */
package LinkedList.Advance;

public class K_reverse_linked_list {
    public ListNode reverseList(ListNode A, int B) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < B) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            A.next = reverseList(next, B);
        }
        return prev;
    }
    public static void main(String[] args) {
        K_reverse_linked_list k = new K_reverse_linked_list();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode newHead = k.reverseList(head, 3);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}


class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
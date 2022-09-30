/*
 * Problem Description
Merge two sorted linked lists, A and B, and return it as a new list.

The new list should be made by splicing together the nodes of the first two lists and should also be sorted.



Problem Constraints
0 <= |A|, |B| <= 105
 */
package LinkedList.Advance;

public class Merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (A != null && B != null) {
            if (A.val < B.val) {
                curr.next = A;
                A = A.next;
            } else {
                curr.next = B;
                B = B.next;
            }
            curr = curr.next;
        }
        if (A != null) {
            curr.next = A;
        }
        if (B != null) {
            curr.next = B;
        }
        return head.next;
    }
    public static void main(String[] args) {
        Merge_two_sorted_lists s = new Merge_two_sorted_lists();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        ListNode newHead = s.mergeTwoLists(head, head2);
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
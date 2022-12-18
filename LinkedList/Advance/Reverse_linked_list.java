/*
 * Problem Description
You are given a singly linked list having head node A. You have to reverse the linked list and return the head node of that reversed list.

NOTE: You have to do it in-place and in one-pass.



Problem Constraints
1 <= Length of linked list <= 105

Value of each node is within the range of a 32-bit integer.
 */
package LinkedList.Advance;

public class Reverse_linked_list {
    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
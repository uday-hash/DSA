/*
 * Problem Description
Given a linked list of integers, find and return the middle element of the linked list.

NOTE: If there are N nodes in the linked list and N is even then return the (N/2 + 1)th element.



Problem Constraints
1 <= length of the linked list <= 100000

1 <= Node value <= 109
 */
package LinkedList.Advance;

public class Middle_element_of_linked_list {
    public int solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
    }
    public static void main(String[] args) {
        Middle_element_of_linked_list m = new Middle_element_of_linked_list();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(m.solve(head));
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
/*
 * Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head.

For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5.

NOTE: If B is greater than the size of the list, remove the first node of the list.

NOTE: Try doing it using constant additional space.



Problem Constraints
1 <= |A| <= 106


 */

package LinkedList.Advance;

public class Remove_Nth_node_from_List_end {
    public ListNode removeNthFromEnd(ListNode A, int B) {
        int count = 0;
        ListNode head = A;
        while (head != null) {
            count++;
            head = head.next;
        }
        if (B >= count) {
            return A.next;
        }
        head = A;
        for (int i = 0; i < count - B - 1; i++) {
            head = head.next;
        }
        head.next = head.next.next;
        return A;
    }
    public static void main(String[] args) {
        Remove_Nth_node_from_List_end r = new Remove_Nth_node_from_List_end();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = r.removeNthFromEnd(head, 2);
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
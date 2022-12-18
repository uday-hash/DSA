/*
 * Problem Description
Given a linked list A, swap every two adjacent nodes and return its head.

NOTE: Your algorithm should use only constant space. 
You may not modify the values in the list; only nodes themselves can be changed.



Problem Constraints
1 <= |A| <= 106
 */
package Doubled_linked_list;

public class Swap_list_nodes_in_pairs {
    public ListNode swapPairs(ListNode A) {
        ListNode head = new ListNode(0);
        head.next = A;
        ListNode curr = head;
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return head.next;

    }
    public static void main(String[] args) {
        Swap_list_nodes_in_pairs s = new Swap_list_nodes_in_pairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = s.swapPairs(head);
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
/*
 * Problem Description
Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.

You have to create a copy of this list and return the head pointer of the duplicated list.



Problem Constraints
1 <= length of the list <= 100000

1 <= Value of node <= 100000
 */
package Doubled_linked_list;

public class Clone_a_linked_list {
    ListNode cloneList(ListNode A) {
        if (A == null)
            return null;
        ListNode curr = A;
        while (curr != null) {
            ListNode temp = new ListNode(curr.val);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        curr = A;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        ListNode head = A.next;
        curr = A;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            if (temp.next != null)
                temp.next = temp.next.next;
            curr = curr.next;
        }
        return head;

    }

}

class ListNode {
    public int val;
    public ListNode next, random;

    ListNode(int x) {
        val = x;
        next = null;
        random = null;
    }
}
/*
 * Problem Description
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|
 */
package LinkedList.Advance;

public class Reverse_Link_List_II {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        ListNode prev = null;
        ListNode curr = A;
        ListNode next = null;
        int count = 1;
        while (count < B) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        ListNode prev1 = prev;
        ListNode curr1 = curr;
        while (count <= C) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (prev1 != null) {
            prev1.next = prev;
        } else {
            A = prev;
        }
        curr1.next = curr;
        return A;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
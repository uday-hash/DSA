/*
 * Problem Description
Given a sorted linked list, delete all duplicates such that each element appears only once.



Problem Constraints
0 <= length of linked list <= 106



 */
package LinkedList.Advance;

public class Remove_duplicates_from_sorted_list {
    public ListNode deleteDuplicates(ListNode A) {
        ListNode curr = A;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return A;
    }
    public static void main(String[] args) {
        Remove_duplicates_from_sorted_list r = new Remove_duplicates_from_sorted_list();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode newHead = r.deleteDuplicates(head);
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
/*
 * Problem Description
You are given two linked lists, A and B, representing two non-negative numbers.

The digits are stored in reverse order, and each of their nodes contains a single digit.

Add the two numbers and return it as a linked list.



Problem Constraints
1 <= |A|, |B| <= 105
 */
package Doubled_linked_list;

public class Add_two_numbers_as_lists {
    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int carry = 0;
        while (A != null || B != null) {
            int sum = carry;
            if (A != null) {
                sum += A.val;
                A = A.next;
            }
            if (B != null) {
                sum += B.val;
                B = B.next;
            }
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head.next;
    }
    public static void main(String[] args) {
        Add_two_numbers_as_lists a = new Add_two_numbers_as_lists();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        ListNode head = a.addTwoNumbers(head1, head2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
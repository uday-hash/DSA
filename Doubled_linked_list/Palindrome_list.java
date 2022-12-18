package Doubled_linked_list;

public class Palindrome_list {
    public int lPalin(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode head1 = A;
        ListNode head2 = prev;
        while (head1 != null && head2 != null) {
            if (head1.val != head2.val) {
                return 0;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return 1;
    }
    public static void main(String[] args) {
        Palindrome_list p = new Palindrome_list();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        System.out.println(p.lPalin(head));
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
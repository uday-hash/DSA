package Doubled_linked_list;

import java.util.*;

public class Merge_k_sorted_lists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        if (a.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(a.size(), new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode node : a) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (pq.size() > 0) {
            ListNode temp = pq.poll();
            curr.next = temp;
            curr = curr.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return head.next;
    }
	public static void main(String[] args) {
        Merge_k_sorted_lists m = new Merge_k_sorted_lists();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(10);
        head1.next.next = new ListNode(20);
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(13);
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(8);
        head3.next.next = new ListNode(9);
        ArrayList<ListNode> a = new ArrayList<ListNode>();
        a.add(head1);
        a.add(head2);
        a.add(head3);
        ListNode head = m.mergeKLists(a);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        
    }
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
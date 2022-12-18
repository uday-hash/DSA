package Heaps;

import java.util.*;

public class Merge_K_sorted_lists {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) != null) {
                minHeap.add(a.get(i));
            }
        }
        ListNode head = null;
        ListNode tail = null;
        while (minHeap.size() > 0) {
            ListNode node = minHeap.poll();
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            if (node.next != null) {
                minHeap.add(node.next);
            }
        }
        return head;

	}
    
    public static void main(String[] args) {
        Merge_K_sorted_lists mksl = new Merge_K_sorted_lists();
        ArrayList<ListNode> a = new ArrayList<>();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(10);
        head1.next.next = new ListNode(20);
        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(11);
        head2.next.next = new ListNode(13);
        ListNode head3 = new ListNode(3);
        head3.next = new ListNode(8);
        head3.next.next = new ListNode(9);
        a.add(head1);
        a.add(head2);
        a.add(head3);
        ListNode head = mksl.mergeKLists(a);
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
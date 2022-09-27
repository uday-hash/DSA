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
}

class ListNode {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
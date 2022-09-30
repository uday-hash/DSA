/*Given a singly linked list, delete middle of the linked list.

For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5

If there are even nodes, then there would be two middle nodes, we need to delete the second middle element.

For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.

Return the head of the linked list after removing the middle node.

If the input linked list has 1 node, then this node should be deleted and a null node should be returned.

 */
package LinkedList.Advance;

public class Delete_middle_node_of_a_Linked_List {
    public ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = slow.next;
        } else {
            A = A.next;
        }
        return A;
    }
    public static void main(String[] args) {
        Delete_middle_node_of_a_Linked_List d = new Delete_middle_node_of_a_Linked_List();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = d.solve(head);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}

class ListNode  {
    public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}
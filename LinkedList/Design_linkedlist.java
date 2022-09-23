/*Problem Description
Given a matrix A of size Nx3 representing operations. Your task is to design the
linked list based on these operations.

There are four types of operations:

0 x -1: Add a node of value x before the first element of the linked list. After the
insertion, the new node will be the first node of the linked list.
1 x -1: Append a node of value x to the last element of the linked list.
2 x index: Add a node of value x before the indexth node in the linked list. If index
equals to the length of linked list, the node will be appended to the end of linked list.
If index is greater than the length, the node will not be inserted.

3 index -1: Delete the indexth node in the linked list, if the index is valid.
A[i][0] represents the type of operation.

A[i][1], A[i][2] represents the corresponding elements with respect to type of operation.

Note: Indexing is 0 based.


Problem Constraints
1 <= Number of operations <= 1000
1 <= All node values <= 109
*/

package LinkedList;

import java.util.ArrayList;

class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

public class Design_linkedlist {
    public ListNode solve(ArrayList<ArrayList<Integer>> A) {
        ListNode head = null;
        for (int i = 0; i < A.size(); i++) {
            int operation = A.get(i).get(0);
            int value = A.get(i).get(1);
            int index = A.get(i).get(2);
            if (operation == 0) {
                ListNode newNode = new ListNode(value);
                newNode.next = head;
                head = newNode;
            } else if (operation == 1) {
                ListNode newNode = new ListNode(value);
                ListNode curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
            } else if (operation == 2) {
                ListNode newNode = new ListNode(value);
                if (index == 0) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    ListNode curr = head;
                    int count = 0;
                    while (count < index - 1 && curr.next != null) {
                        curr = curr.next;
                        count++;
                    }
                    newNode.next = curr.next;
                    curr.next = newNode;
                }
            } else if (operation == 3) {
                if (index == 0) {
                    head = head.next;
                } else {
                    ListNode curr = head;
                    int count = 0;
                    while (count < index - 1 && curr.next != null) {
                        curr = curr.next;
                        count++;
                    }
                    curr.next = curr.next.next;
                }
            }
        }
        return head;
    }
}

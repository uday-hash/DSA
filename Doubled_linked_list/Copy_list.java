/*
 * Problem Description
A linked list A is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.



Problem Constraints
0 <= |A| <= 106
 */
package Doubled_linked_list;

//import java.util.*;

public class Copy_list {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode temp = new RandomListNode(curr.label);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        RandomListNode newHead = head.next;
        RandomListNode newCurr = newHead;
        curr = head;
        while (curr != null) {
            curr.next = curr.next.next;
            if (newCurr.next != null) {
                newCurr.next = newCurr.next.next;
            }
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }
    public static void main(String[] args) {
        Copy_list c = new Copy_list();
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        RandomListNode newHead = c.copyRandomList(head);
        while (newHead != null) {
            System.out.println(newHead.label);
            newHead = newHead.next;
        }
    }


}

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
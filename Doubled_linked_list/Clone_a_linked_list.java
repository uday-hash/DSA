/*
 * Problem Description
Given a doubly linked list of integers with one pointer of each node pointing to the next node (just like in a single link list) while the second pointer, however, can point to any node in the list and not just the previous node.

You have to create a copy of this list and return the head pointer of the duplicated list.



Problem Constraints
1 <= length of the list <= 100000

1 <= Value of node <= 100000
 */
package Doubled_linked_list;

public class Clone_a_linked_list {
    ListNode cloneList(ListNode A) {
        
    
    }
    
}

class ListNode {
    public int val;
    public ListNode next,random;
    ListNode(int x) { 
        val = x; 
        next = null;
        random = null;
    }
}
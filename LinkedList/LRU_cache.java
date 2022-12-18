/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache,
 otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reaches its capacity, it should invalidate the least recently
 used item before inserting the new item.
The LRUCache will be initialized with an integer corresponding to its capacity.
 Capacity indicates the maximum number of unique keys it can hold at a time.

Definition of "least recently used" : An access to an item is defined as a get 
or a set operation of the item. "Least recently used" item is the one with the 
oldest access time.

NOTE: If you are using any global variables, make sure to clear them in the 
constructor.

Example :

Input : 
         capacity = 2
         set(1, 10)
         set(5, 12)
         get(5)        returns 12
         get(1)        returns 10
         get(10)       returns -1
         set(6, 14)    this pushes out key = 5 as LRU is full. 
         get(5)        returns -1 

         If lets say you never had to remove entries from the LRU cache because we had enough space, what would you use to support and get and set ?
A simple map / hashmap would suffice.

Alright, lets now look at the second part which is where the eviction comes in. We need a data structure which at any given instance can give me the least recently used objects in order. Lets see if we can maintain a linked list to do it. We try to keep the list ordered by the order in which they are used. So whenever, a get operation happens, we would need to move that object from a certain position in the list to the front of the list. Which means a delete followed by insert at the beginning.

Insert at the beginning of the list is trivial. How do we achieve erase of the object from a random position in least time possible ?

How about we maintain another map which stores the pointer to the corresponding linked list node.

Ok, now when we know the node, we would need to know its previous and next node in the list to enable the deletion of the node from the list. We can get the next in the list from next pointer ? What about the previous node ? To encounter that, we make the list doubly linked list.

 */

package LinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRU_cache {

    public LRU_cache(int capacity) {
    // TODO Auto-generated constructor stub
    this.capacity = capacity;
    this.count = 0;
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
    head.prev = null;
    tail.next = null;
    }

    
    public int get(int key){
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        }
        return -1;

    }

    public void set(int key, int value) {
        // TODO Auto-generated method stub
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }

    }

    private void deleteNode(Node node) {
        // TODO Auto-generated method stub
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        // TODO Auto-generated method stub
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private int capacity;
    private int count;
    private Map<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head, tail;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LRU_cache cache = new LRU_cache(2);
        cache.set(1, 10);
        cache.set(5, 12);
        System.out.println(cache.get(5));
        System.out.println(cache.get(1));
        System.out.println(cache.get(10));
        cache.set(6, 14);
        System.out.println(cache.get(5));
    }
    
}

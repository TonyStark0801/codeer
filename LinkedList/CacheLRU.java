package LinkedList;//package LinkedList;
//
import java.util.HashMap;
import java.util.List;

//
public class CacheLRU {
    public static void main(String[] args) {
//        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 10);  // cache: {1=10}
//        System.out.println(lRUCache.get(1));      // return 10
//        lRUCache.put(2, 20);  // cache: {1=10, 2=20}
//        lRUCache.put(3, 30);  // cache: {2=20, 3=30}, key=1 was evicted
//        System.out.println(lRUCache.get(2));      // returns 20
//        System.out.println(lRUCache.get(1));


        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);  // cache: {1=1}
        lRUCache.put(2, 2);  // cache: {1=1, 2=2}
        System.out.println(lRUCache.get(1));  // returns 1
        lRUCache.put(3, 3);  // cache: {2=2, 3=3}, key 1 was evicted
        System.out.println(lRUCache.get(2));  // returns 2
        lRUCache.put(4, 4);  // cache: {3=3, 4=4}, key 2 was evicted
        System.out.println(lRUCache.get(1));  // returns -1 (not found)
        System.out.println(lRUCache.get(3));  // returns 3
        System.out.println(lRUCache.get(4));


    }
}
////
////class Node{
////    int key;
////    int val;
////    Node next;
////    Node prev;
////
////    public Node(){}
////
////    //Single Node
////    public Node(int key, int val){
////        this.key=key;
////        this.val=val;
////        this.next=null;
////        this.prev=null;
////    }
////
////    //Doubly Linked list
////    public Node(int key, int val,Node next,Node prev){
////        this.key=key;
////        this.val=val;
////        this.next=next;
////        this.prev=prev;
////    }
////
////}
//
//class LRUCache {
//    private HashMap<Integer, Integer> cache;
//    // private Node head,tail;
//    private int capacity;
//    private int last;
//
//    public LRUCache(int capacity) {
//        this.capacity = capacity;
//        this.cache = new HashMap<>();
//        // head = new Node(-1,-1);
//        // tail = head;
//        System.out.println(cache);
//    }
//
//    public int get(int key) {
//        if(cache.containsKey(key)) return cache.get(key);
//        System.out.println(cache);
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if(cache.size()==capacity){
//            cache.remove(last);
//        }
//        cache.put(key,value);
//        last = key;
//        System.out.println(cache);
//        System.out.println("Capacity: "+capacity+" filled: "+cache.size() +" last: "+last);
//
//    }
//}
//
//



class DoubleNode {
    int key;
    int val;
    DoubleNode next;
    DoubleNode prev;

    // Constructor for the Node
    public DoubleNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    private final HashMap<Integer, DoubleNode> cache;
    private DoubleNode head, tail;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = null; // Empty list
        tail = null; // tail points to head initially
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleNode node = cache.get(key);
            moveNode(node);
            return node.val;
        }
        return -1;
    }

    private void moveNode(DoubleNode node) {
        if(node.prev!=null) node.prev.next = node.next;
        if(node.next!=null) node.next.prev = node.prev;
        if(head!=null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
    }

    public void put(int key, int value) {
        DoubleNode newNode = new DoubleNode(key, value);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        cache.put(key, newNode);
        if (cache.size() > capacity) {
            cache.remove(head.key);
            head = head.next;
            if (head != null) {
                head.prev = null; // Set head's previous to null
            }
        }
        System.out.println(cache);
        DoubleNode iterator = head;
        while (iterator != null) {
            System.out.print(iterator.key + "->");
            iterator = iterator.next;
        }
        System.out.print("null\n");
    }
}

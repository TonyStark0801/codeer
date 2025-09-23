package LinkedList;
/**
 * <h1>138. Copy List with Random Pointer</h1>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list
 * such that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * Return the head of the copied linked list.
 */

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class CopyListWithRandomPointer {

    public static void printList(Node head, String listName) {
        System.out.println("=== " + listName + " ===");
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.println("Node " + index + " -> val: " + current.val +
                    ", random: " + (current.random != null ? current.random.val : "null"));
            current = current.next;
            index++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CopyListWithRandomPointer solution = new CopyListWithRandomPointer();
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        printList(node1, "Original List");
        Node copiedHead = solution.copyRandomList(node1);
        printList(copiedHead, "Copied List");
    }



    public Node copyRandomList(Node head) {
        while(head!=null){
            Node newNode   = new Node(head.val);
        }

        return null;
    }
}

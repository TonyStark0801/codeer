package LinkedList;

public class ListNode {
    int val;
    LinkedList.ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, LinkedList.ListNode next) { this.val = val; this.next = next; }

    static void printList(ListNode head){
        ListNode iterator = head;
        while(iterator!=null){
            System.out.print(iterator.val+"->");
            iterator = iterator.next;
        }
        System.out.print("null\n");
    }

    static ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }
}




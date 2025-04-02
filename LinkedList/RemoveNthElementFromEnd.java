package LinkedList;

import static LinkedList.ListNode.createLinkedList;
import static LinkedList.ListNode.printList;

public class RemoveNthElementFromEnd {
    public static void main(String[] args) {
        int[] values = { 1,2,3,4,5};
        ListNode head = createLinkedList(values);

        System.out.println("Original");
        printList(head);
        System.out.println("\nResult");
        printList(removeNthFromEnd(head,5 ));

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int size =0;
        while(curr!= null){
            size++;
            curr= curr.next;
        }
        int nodeCounter=1;
        curr = head;

        int nthElement = size-n;
        System.out.println("Nth Element to be removed "+nthElement);
        if(nthElement==0) return  head.next;
        while ( curr!=null){
            System.out.println("current element: "+curr.val);
            if(nodeCounter==nthElement){
                curr.next = curr.next.next;
                break;
            }
            nodeCounter++;
            curr = curr.next;
        }
        System.out.println(size);
        System.out.println(nthElement);

        return  head;
    }
}

package LinkedList;

import static LinkedList.ListNode.createLinkedList;
import static LinkedList.ListNode.printList;

public class ReorderList {
    public static void main(String[] args) {
        int[] values = { 1,2,3,4};
//        int[] values = {};
        ListNode head = createLinkedList(values);


        //1->4->3->4
        System.out.println("Original");
        printList(head);

        System.out.println("\nReordering");
        reorderList(head);
        printList(head);

    }

//    private static ListNode reorderList(ListNode head) {
//        ListNode left = head;
//        ListNode right = head;
//        if(head == null) return null;
//        while ( left.next !=null &&  left.next.next != null){
//            while(right.next.next!=null){
//                right = right.next;
//            }
//            ListNode temp = left;
//            left = left.next;
//            temp.next = right.next;
//            right.next.next = left;
//            right.next =null;
//            right = left;
//            printList(head);
//        }
//        return  head;
//  }

    private static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        //Go to mid
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //now reverse from mid to end
        ListNode secondHalf = reverseList(slow.next);
        slow.next = null; // break the list


        //merging the first and second half
        ListNode firstHalf = head;
        while (secondHalf != null) {
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = secondHalf.next;

            firstHalf.next = secondHalf;  // Link first half to second half
            secondHalf.next = tmp1;  // Link second half to the next node in the first half

            firstHalf = tmp1;  // Move to the next node in the first half
            secondHalf = tmp2;  // Move to the next node in the second half
        }
    }

    // Helper method to reverse the linked list
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;  // Return the new head of the reversed list
    }

}

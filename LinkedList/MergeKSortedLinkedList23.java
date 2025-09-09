package LinkedList;


import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 **/

public class MergeKSortedLinkedList23 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createLinkedList(new int[]{1, 4, 5});
        ListNode l2 = ListNode.createLinkedList(new int[]{2, 6, 7});
        ListNode l3 = ListNode.createLinkedList(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(l3);
        System.out.println("---------");
        mergeKLists(lists);
//        ListNode.printList(mergeKLists(lists));

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        for (int i = 0; i < lists.length - 1; i++) {
            mergeToResult(lists[i], lists[i + 1],result);
            ListNode.printList(result);
            break;
        }
        return result;
    }

    public static void mergeToResult(ListNode l1, ListNode l2, ListNode result) {
        while (l2!=null && l1!=null){
            ListNode newNode;
            if(l1.val < l2.val){
                newNode = l1;
                newNode.next = l2;
            }
            else {
                newNode = l2;
                newNode.next = l1;
            }
            if(result==null) result = newNode;
            else result.next = newNode;
            l1 = l1.next;
            l2 = l2.next;
            ListNode.printList(result);


//            if(l1.next != null && l2.val > l1.next.val){
//                l1 = l1.next;
//                continue;
//            }
//            ListNode temp = l2;
//            l2 = l2.next;
//            temp.next = l1.next;
//            l1.next = temp;
//            ListNode.printList(l1);
//            ListNode.printList(l2);
//            System.out.println("EOD");
        }

    }

}



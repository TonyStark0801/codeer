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
            mergeToResult(lists[i], lists[i + 1], result);
            ListNode.printList(result);
            break;
        }
        return result;
    }

    public static void mergeToResult(ListNode list1, ListNode list2, ListNode result) {
        ListNode iterator = result;
        while (list1 != null && list2 != null) {
            ListNode node;
            if (list1.val <= list2.val) {
                node = list1;
                list1 = list1.next;
            } else {
                node = list2;
                list2 = list2.next;
            }
            if (result != null) iterator.next = node;
            else {
                result = iterator = node;
            }
            iterator = iterator.next;
        }

        while (list1!=null){
            iterator.next =list1;
            list1 = list1.next;
        }
        while (list2!=null){
            iterator.next =list2;
            list2 = list2.next;
        }
        ListNode.printList(result);

    }

}



package LinkedList;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 **/

public class MergeKSortedLinkedList23 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createLinkedList(new int[]{1,4,5});
        ListNode l2= ListNode.createLinkedList(new int[]{2,6,7});
        ListNode l3 = ListNode.createLinkedList(new int[]{2,6});

        ListNode[] lists = new ListNode[]{l1,l2,l3};
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(l3);
        System.out.println("---------");
        ListNode.printList(mergeKLists(lists));

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = lists[0];

        for (int i = 1; i < lists.length ; i++) {
            mergeToResult(result,lists[i]);
        }
        return result;
    }

    public static void mergeToResult(ListNode res, ListNode list){
        ListNode result = res;
        while (result !=null && list!=null){
            if(list.val < result.val){
                ListNode temp = list.next;
                list.next = result;
                result.next = list;
                list = temp;
                result = result.next;
            }
            ListNode.printList(res);
        }
    }

}



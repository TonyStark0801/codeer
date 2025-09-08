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
        ListNode l4 = ListNode.createLinkedList(new int[]{0,4,5,6,8,9,11,15});

        ListNode[] lists = new ListNode[]{l1,l2,l3,l4};
        ListNode.printList(l1);
        ListNode.printList(l2);
        ListNode.printList(l3);
        ListNode.printList(l4);
        System.out.println("---------");
        MergeKSortedLinkedList23 mass = new MergeKSortedLinkedList23();
        ListNode.printList(mass.mergeKLists(lists));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return divideAndMerge(lists,0,lists.length-1);


    }


    public  ListNode divideAndMerge(ListNode[] lists,  int start, int end){
        if(start == end) return lists[start];

        int mid  =  start +(end-start)/2;
        ListNode left = divideAndMerge(lists, start, mid);
        ListNode right = divideAndMerge(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode cpy = res;
        while(l1 !=null && l2 !=null){
            if(l1.val<=l2.val){
                cpy.next = l1;
                l1 = l1.next;
            }
            else {
                cpy.next = l2;
                l2 = l2.next;
            }

            cpy = cpy.next;
        }

        while(l1!=null){
            cpy.next = l1;
            l1 = l1.next;
            cpy = cpy.next;
        }
        while(l2!=null){
            cpy.next = l2;
            l2 = l2.next;
            cpy = cpy.next;
        }

        return res.next;

    }


}



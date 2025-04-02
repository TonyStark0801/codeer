package Tree;

import java.text.BreakIterator;

public class CountGoodNodes {
    public static void main(String[] args) {
//        int[] arr = {2,4,4,4,-1,1,3,-1,-1,5,-1,-1,-1,-1,5,4,4};
        int[] arr = {};

        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        int[] counter = new int[1];
        countNodes(root,root,counter);
        return counter[0];
    }

    public static void countNodes(TreeNode head,TreeNode root,int[] counter){
        if(head==null) return;
        TreeNode temp ;
        if(head.val>=root.val){
            counter[0]++;
            temp = head;
        }
        else temp = root;
        if(head.left!=null ) countNodes(head.left,temp,counter);
        if(head.right!=null) countNodes(head.right,temp,counter);

        System.out.println("head: "+head.val);

    }
}

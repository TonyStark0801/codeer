package Tree;

import java.util.Arrays;

public class ValidBinarySearchTree {
    public static void main(String[] args) {
//        int[] arr = {5,4,6,-1,-1,3,7};
        int[] arr ={5,4,6,-1,-1,3,7};
        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {

        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;

        if (root==null) return true;
        return  validBST(root,low,high);
    }

    public static boolean validBST(TreeNode head,int low,int high){
        if(head ==null) return true;
        if(head.val<=low || head.val>=high) return false;
        return validBST(head.left,low,head.val) && validBST(head.right, head.val, high);
    }
}

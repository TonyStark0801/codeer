package Tree;

import java.util.HashMap;
import java.util.Map;

public class KthSmallestIntegerBST {
    public static void main(String[] args) {
        int[] arr ={5,4,7,-1,-1,6,8};
        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(kthSmallest(root,0));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int[] cache = new int[2];
        // cache[0] -> stores the position of the lowest
        //cache[1] -> stores the lowest at that position
        cache[1] = Integer.MIN_VALUE;

        kSmallest(root,k,cache);
        return cache[1];

    }

    private static void kSmallest(TreeNode root, int k, int[] cache) {
        if(cache[0]==k) return;
        if(root.left!=null) kSmallest(root.left,k,cache);
        if(cache[0]==k) return;
        cache[0]++;
        cache[1] = root.val;
        if(root.right!=null) kSmallest(root.right,k,cache);


    }
}

package Tree;

import com.sun.source.tree.Tree;

public class BalancedBinaryTree {
    public static void main(String[] args) {
//        int [] arr = {1,2,3,-1,-1,4,-1,5};
        int[] arr = {1,2,2,3,-1,-1,3,4,-1,-1,4};
        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        return checkBalanced(root) != -1;
    }

    private static int checkBalanced(TreeNode root) {

        if(root==null) return 0;
        int leftHeight = checkBalanced(root.left);
        int rightHeight = checkBalanced(root.right);
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;

    }

}

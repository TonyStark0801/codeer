package Tree;

public class MaximumDepth {
    public static void main(String[] args) {
        int[] arr = {1,2,3,-1,-1,4,-1,5};

        TreeNode root = TreeNode.createTreeFromArray(arr);

        System.out.println("Tree (In-order) Original ");
        TreeNode.printTree(root);
        System.out.println(maxDepth(root));
    }
    public static  int maxDepth(TreeNode root) {
        if(root ==null) return 0;
        int leftMax , rightMax;

        leftMax = maxDepth(root.left)+1;
        rightMax = maxDepth(root.right)+1;
        return Math.max(leftMax,rightMax);
    }

}

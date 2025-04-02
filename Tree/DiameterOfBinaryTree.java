package Tree;

public class DiameterOfBinaryTree {
    static int diameter = 0;
    public static void main(String[] args) {
//        int[] arr = {1,-1,2,3,4,5,-1,-1,6};
        int[] arr = {1,2,3};
        TreeNode root= TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        int[] diameter = new int[1];
        System.out.println(maxDepth(root,diameter));
        System.out.println(diameter[0]);
    }

    public static  int maxDepth(TreeNode root,int[] diameter) {
        if(root ==null) return 0;
        int leftMax , rightMax;
        leftMax = maxDepth(root.left,diameter);
        rightMax = maxDepth(root.right,diameter);
        diameter[0] = Math.max(leftMax+rightMax, diameter[0]);
        return Math.max(leftMax,rightMax)+1;
    }

}

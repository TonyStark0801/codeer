package Tree;

public class InverseBinaryTree {
    // Main method for testing
    public static void main(String[] args) {
        // Example tree: [1, 2, 3, 4, 5, 6, 7]
        int[] arr = {};

        TreeNode root = TreeNode.createTreeFromArray(arr);

        System.out.println("Tree (In-order) Original ");
        TreeNode.printTree(root);

        System.out.println("\nTree (In-order) New ");
        TreeNode.printTree(inverseTree(root));
        System.out.println();
    }

    public static  TreeNode inverseTree(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left!=null)   inverseTree(root.left);
        if (root.right!=null)  inverseTree(root.right);
        return  root;
    }
}

package Tree;

public class IsSubTree {
    public static void main(String[] args) {
        int[] pArr = {2,2};
        int[] qArr = {2,2,3};
        TreeNode root = TreeNode.createTreeFromArray(pArr);
        TreeNode subroot = TreeNode.createTreeFromArray(qArr);
        TreeNode.printTree(root);
        System.out.println("-----------------------");
        TreeNode.printTree(subroot);

        System.out.println(isSubtree(root,subroot));

    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(root.val == subRoot.val && isSameTree(root,subRoot)) return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == subRoot;
        if (root.val != subRoot.val) return false;
        boolean left =  isSameTree(root.left, subRoot.left);
        boolean right = isSameTree(root.right, subRoot.right);
        return left && right;
    }
}

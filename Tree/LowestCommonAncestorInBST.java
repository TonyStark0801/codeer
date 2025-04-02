package Tree;

public class LowestCommonAncestorInBST {
    public static void main(String[] args) {
        int[] arr = {5,3,8,1,4,7,9,-1,2};
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(4);

        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(lowestCommonAncestor(root,p,q).val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int big = Math.max(p.val, q.val);
        int small = Math.min(p.val,q.val);
        if(small <=root.val && big >=root.val) return root;
        if(big<root.val) return lowestCommonAncestor(root.left,p,q);
        return lowestCommonAncestor(root.right,p,q);
    }
}

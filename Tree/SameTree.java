package Tree;

public class SameTree {
    public static void main(String[] args) {
        int[] pArr = {1,2};
        int[] qArr = {1,2};
        TreeNode p = TreeNode.createTreeFromArray(pArr);
        TreeNode q = TreeNode.createTreeFromArray(qArr);
        TreeNode.printTree(p);
        System.out.println("-----------------------");
        TreeNode.printTree(q);

        System.out.println(isSameTree(p,q));

    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        boolean left =  isSameTree(p.left,q.left);
        boolean right = isSameTree(p.right,q.right);
        return left && right;
    }
}

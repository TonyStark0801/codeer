package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(rightSideView(root));
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer>  res = new ArrayList<>();
        if(root == null) return  res;
        traverseRight(root,res,0);
        return res;
    }

    public static void traverseRight(TreeNode root, List<Integer> res, int level){
//        System.out.println(level +"->"+root.val);
        if (res.size() == level) res.add(level,root.val);
        else res.set(level,root.val);
        if(root.left!=null) traverseRight(root.left,res,level+1);
        if(root.right!=null) traverseRight(root.right,res,level+1);
    }
}

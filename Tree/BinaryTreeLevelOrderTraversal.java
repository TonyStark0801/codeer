package Tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,7,8,-1,-1,-1,-1,10};
        TreeNode root = TreeNode.createTreeFromArray(arr);
        TreeNode.printTree(root);
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  res = new ArrayList<>();
        if(root == null) return  res;
        traverseTree(root,res,0);
        return res;
    }
    public static void  traverseTree(TreeNode root,List<List<Integer>> res,int level){
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        if(root.left!=null) traverseTree(root.left,res,level+1);
        if(root.right!=null) traverseTree(root.right,res,level+1);
    }


}

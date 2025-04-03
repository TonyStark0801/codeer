package Tree;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreorderInorderTraversal {
    private  Stack<Integer> st ;
    private  int rootTracker=0;
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        Stack<Integer> st = new Stack<>();
        TreeNode root = TreeNode.createTreeFromArray(new int[]{3,9,20,-1 ,-1,15,7});
        TreeNode.printTree(root);
        ConstructBinaryTreeFromPreorderInorderTraversal s = new ConstructBinaryTreeFromPreorderInorderTraversal();
        TreeNode.printTree(s.buildTree(preorder,inorder));
    }

    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        st = new Stack<>();
        HashMap<Integer,Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.putIfAbsent(inorder[i],i);
        }
        return build(preorder, inorderIndexMap,0,inorder.length-1);
    }

    private  TreeNode build(int[] preorder,  HashMap<Integer,Integer> inorderIndexMap, int left,int right) {
        if(left>right) return null;

        TreeNode root = new TreeNode(preorder[rootTracker++]);
        int rootIndex = inorderIndexMap.get(root.val);

        root.left = build(preorder,inorderIndexMap,left,rootIndex-1);
        root.right = build(preorder,inorderIndexMap,rootIndex+1,right);
        return root;
    }
}

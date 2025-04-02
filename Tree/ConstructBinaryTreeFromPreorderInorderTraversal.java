package Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreorderInorderTraversal {
    private  Stack<Integer> st ;
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
        for(int i=preorder.length-1;i>=0;i--){
            st.add(preorder[i]);
        }
        List<Integer> arr = Arrays.stream(inorder).boxed().toList();
        return build(st,arr);
    }

    private  TreeNode build(Stack<Integer> st,List<Integer> arr) {
        TreeNode root = new TreeNode(st.pop());
        boolean rootFound = false;
        List<Integer> left =new ArrayList<>();
        List<Integer> right =new ArrayList<>();
        for(int x: arr){
            if(x==root.val) {
                rootFound =true;
                continue;
            }
            if(rootFound ) right.add(x);
            else left.add(x);
        }
        if(!left.isEmpty()) root.left =build(st,left);
        if(!right.isEmpty()) root.right = build(st,right);
        return root;
    }
}

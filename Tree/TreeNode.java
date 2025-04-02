package Tree;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Function to create a binary tree from an array (level-order)
    public static TreeNode createTreeFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int index = 1;

        while (index < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (arr[index] != -1) {
                current.left = new TreeNode(arr[index]);
                queue.add(current.left);
            }
            index++;

            // Right child
            if (index < arr.length && arr[index] != -1) {
                current.right = new TreeNode(arr[index]);
                queue.add(current.right);
            }
            index++;
        }

        return root;
    }

    public static void printTree(TreeNode root) {
        if(root==null) return;
        int height = getHeight(root);
        int width = (int)Math.pow(2, height) - 1;

        // Create a 2D array to store the tree structure
        String[][] treeGrid = new String[height * 2 - 1][width];

        // Fill the grid with tree visualization
        fillTreeGrid(root, treeGrid, 0, 0, width - 1);

        // Print the grid
        for (String[] row : treeGrid) {
            for (String cell : row) {
                System.out.print(cell == null ? " " : cell);
            }
            System.out.println();
        }
    }

    private static void fillTreeGrid(TreeNode node, String[][] grid, int row, int left, int right) {
        if (node == null) return;

        // Find the middle of the current range
        int mid = (left + right) / 2;

        // Place the node value
        grid[row][mid] = String.valueOf(node.val);

        // If there's a left child
        if (node.left != null) {
            grid[row + 1][mid - 1] = "/";
            fillTreeGrid(node.left, grid, row + 2, left, mid - 1);
        }

        // If there's a right child
        if (node.right != null) {
            grid[row + 1][mid + 1] = "\\";
            fillTreeGrid(node.right, grid, row + 2, mid + 1, right);
        }
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

}

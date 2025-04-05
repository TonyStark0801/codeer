package Array;

import java.util.Arrays;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] matrix = {
                {-9,-8,-8},{-5,-3,-2},{0,2,2},{4,6,8}

        };
        int target = 15; // You can test with other targets like 16, 20, etc.
        System.out.println(searchMatrix(matrix, target));  // Should return true
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Deciding the row based on binary search logic.
        int left = 0;
        int right = matrix.length - 1;

        while (left <right) {  // Corrected to ensure we check the final row
            int mid = (left + right) / 2;

            // Print to debug which row is being considered
            System.out.println("Checking row " + mid + ": " + Arrays.toString(matrix[mid]));

            // Now perform binary search on the row for the target
            if (binarySearch(matrix[mid], 0, matrix[mid].length - 1, target)) {
                return true; // Found target in the current row
            } else if (matrix[mid][0] > target) {
                right = mid - 1; // Narrow down to the rows above
            } else {
                left = mid + 1; // Narrow down to the rows below
            }

        }

        //the final check
        return binarySearch(matrix[left], 0, matrix[left].length - 1, target);

    }

    // Binary search in a given row
    public static boolean binarySearch(int[] nums, int left, int right, int target) {
        System.out.println("Binary Search in row: " + Arrays.toString(nums));
        System.out.println("Left: " + left + ", Right: " + right);

        if (left > right) return false;  // Base case: target not found in the row

        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return true; // Target found in this row
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target); // Search in the right half
        } else {
            return binarySearch(nums, left, mid - 1, target); // Search in the left half
        }
    }
}

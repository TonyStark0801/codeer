import java.util.Scanner;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] h = {1,3,7}; //10
        System.out.println(largestRectangleArea(h));

    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int max_area = 0;
        for (int i = 0; i < n; i++) {
            if(i==n-1) return Math.max(max_area, heights[i]);
            int j =i+1;
            if (heights[i] > heights[j]) {
                max_area = Math.max(max_area, heights[i] * (j - i));
                System.out.println("breaking, Max area = " + max_area);
                continue;
            }
            while (j < n && heights[i] <= heights[j]) {
                System.out.println(heights[i] + " " + heights[j]);
                j++;
            }
            j--;

            System.out.println(heights[i] + " " + heights[j]);
            max_area = Math.max(max_area, heights[i] * (j - i+1));
            System.out.println("End, Max area = " + max_area);

        }
        return max_area;
    }
}

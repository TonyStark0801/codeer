package Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(arr));
    }
    public static  int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        // next smaller element -> nse
        for (int nse = 0; nse <= n ; nse++) {
            int currHeight = (nse == n) ? 0 : heights[nse];
            while(!st.isEmpty() && currHeight<heights[st.peek()]){
                int height = heights[st.pop()];
                int pse = st.empty()?-1:st.peek();
                maxArea  = Math.max(maxArea,height *(nse -pse-1));
            }
            st.add(nse);
        }


        return maxArea;
    }
}

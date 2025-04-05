package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrappingRainWater {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Arrays.toString(height));
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }
    //Solution:1
    public static int trap(int[] height) {
        int size = height.length;
        int[] right = new int[size];
        right[size-1] = height[size-1];
        List<Integer> list = new ArrayList<>();
        for(int i =size-2; i>=0;i--){
            right[i] = Math.max(height[i],right[i+1]);
        }
        int sumOfWater = 0;
        int max = 0;
        for (int i = 0; i < size; i++) {
            max = Math.max(max,height[i]);
            list.add(Math.min(max,right[i])-height[i]);
            sumOfWater+=Math.min(max,right[i])-height[i];
        }
        System.out.println(list);
        return sumOfWater;
    }

    //Solution2:
    public static int trap2(int[] height) {
        int size = height.length;
        int sumofWater =0;
        int l = 0;
        int r = size-1;
        int leftMax = 0;
        int rightMax =0;
        int val = 0;
        while (l<r){
           if(height[l]<=height[r]){
               leftMax = Math.max(leftMax,height[l]);
               sumofWater += Math.min(leftMax,height[r])-height[l];
               l++;
           }
           else{
               rightMax = Math.max(rightMax,height[r]);
               sumofWater += Math.min(rightMax,height[l])-height[r];
               r--;
           }
        }
        return sumofWater;
    }


}

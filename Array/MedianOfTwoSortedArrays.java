package Array;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,8};
        int[] nums2 = {3,4,5};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }


    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr =mergeArray(nums1,nums2);
        int size = arr.length;
        System.out.println(Arrays.toString(arr));
        if(size%2==0)  return (double) (arr[size / 2] + arr[(size / 2 - 1)]) /2;
        else return  arr[size/2];


/*
        Potential solution
        System.out.println(size);
        if(size%2==0) {
            System.out.println("even");
            System.out.println("index:");
        }
        else System.out.println("odd");
*/
    }

    static int[] mergeArray(int[] nums1, int[] nums2){
        int size = nums2.length + nums1.length;
        int[] arr = new int[size];
        int i =0;
        int j= 0;
        int k=0;

        while (i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k]= nums2[j];
                j++;
            }
            k++;
        }

        while (i<nums1.length){
            arr[k] = nums1[i];
            i++;
            k++;
        }

        while (j<nums2.length){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        return  arr;
    }
}

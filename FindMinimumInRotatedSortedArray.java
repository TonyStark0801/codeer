public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        System.out.println(findMinimum(new int[]{5,6,7,8,9,10,11,0}));

    }

    private static int findMinimum(int[] nums) {
        int i=0;
        int j= nums.length-1;
        int min=nums[0];

        //Corner Case: Non-rotated or single element array.
        if(nums[i]<=nums[j])  return nums[i];

        while(i<=j){
            int mid = (i+j)/2;
            //mid itself is the lowest   - 4 5 6 (0) 1
            if(i<mid && nums[mid]<nums[mid-1]) return nums[mid];

            //or the next element
            if(j>mid && nums[mid]>nums[mid+1]) return nums[mid+1];

            //now decide which to take left or right part
            //left > mid : which means minimum is on left side.
            if(nums[i]>nums[mid]){
                j = mid-1;

            }
            //or on the right side
            else i=mid+1;
        }
        return -1;
    }
}

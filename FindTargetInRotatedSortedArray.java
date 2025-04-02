public class FindTargetInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {11,13,15,17};
        System.out.println(findTarget(new int[]{5,6,7,0},0));

    }

    private static int findTarget(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;

        while(left<=right){
            int mid = (left+right)/2;
            if(target == nums[mid]) return mid;
            if(nums[left]<=nums[mid]){
                if(target>=nums[left] && target<=nums[mid] ) right=mid;
                else left =mid+1;
            }
            else{
                if(target>=nums[mid] && target <= nums[right]) left=mid;
                else right=mid-1;
            }
        }
        return -1;
    }
}

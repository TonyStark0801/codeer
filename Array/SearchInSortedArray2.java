package Array;

/**
 * <h4>LEVEL: MEDIUM<h4/>
 * Searches for a target value in a rotated sorted array that may contain duplicates.
 * The array is sorted in a non-decreasing order and rotated at an unknown pivot.
 * <p>
 * Example:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * <p>
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * <p>
 * Constraints:
 * - 1 <= nums.length <= 5000
 * - -10^4 <= nums[i] <= 10^4
 * - nums is guaranteed to be rotated at some pivot.
 * - -10^4 <= target <= 10^4
 */
public class SearchInSortedArray2 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        SearchInSortedArray2 sol = new SearchInSortedArray2();
        System.out.println(sol.search(nums, 0));
        System.out.println(sol.search(new int[]{1, 0, 1, 1, 1}, 0));
    }


    public boolean search(int[] nums, int target) {

        int centerIndex = findCenterIndex(nums);
        return  search(nums,0,centerIndex,target ) || search(nums,centerIndex,nums.length-1,target);


    }

    public boolean search (int[] nums , int left, int right,int target){
        if(left == right && nums[left] == target) return true;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) return true;
            if (target >= nums[left] && target <= nums[mid]) right = mid;
            else left = mid + 1;

        }
        return false;
    }

    private int findCenterIndex(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>nums[i+1]) return i+1;
        }
        return 0;
    }

}

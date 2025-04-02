public class BinarySearch {
    public static void main(String[] args) {
        System.out.println("Old Method");
        System.out.println(search(new int[]{-1,0,2,4,6,8},4));
        System.out.println(search(new int[]{-1,0,2,4,6,8},3));
        System.out.println("Recursive Method");
        int[] nums = new int[]{-1,0,2,4,6,8};
        System.out.println(search2(nums,0,nums.length-1,4));
        System.out.println(search2(nums,0,nums.length-1,3));

    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if(nums[mid]==target) return mid;
            else if (nums[mid]<target)  left=mid+1;
            else right = mid - 1;

        }
        return -1;
    }

    public static int search2(int[] nums,int left, int right, int target) {
        if(left>right) return -1;
        int mid = (left+right)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]<target) return search2(nums,mid+1,right,target);
        else return search2(nums,left,mid-1,target);
    }
}

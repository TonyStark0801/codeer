import java.util.*;
import java.lang.Math;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
//        int[] nums = {2, 20, 4, 10, 3, 4, 5,1,6,8};
        int[] nums = {0,3,2,5,4,6,1,1};
        System.out.println(longestConsecutive(nums));
    }


    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        int max_count=1;

        for (int x : nums){
            numSet.add(x);
        }
        System.out.println(numSet);

        for (int num : numSet) {
            int start = num;
            int counter=1;
            while (numSet.contains(start+1)){
                start++;
                counter++;
            }

            max_count = Math.max(counter, max_count);
        }

        return max_count;
    }
}




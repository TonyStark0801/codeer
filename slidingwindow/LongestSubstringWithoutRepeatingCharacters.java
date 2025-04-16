package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s1 = "dvdf";
        String s2 = "pwwek";
        System.out.println(s1);
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(s2);
        System.out.println(lengthOfLongestSubstring1(s2));
    }


    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> set  = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxsize = 0;

        while (i<=j && j<s.length()){
            char current = s.charAt(j);
            if(set.containsKey(current)){
                i =  set.get(current)+1;
            }
            set.put(current,j);
            maxsize = Math.max(maxsize,j-i);
            j++;
            System.out.println(set);
        }

        return Math.max(maxsize,set.size());
    }

    public static int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> visitedChars = new HashMap<>();
        //right -> right pointer (end of string)
        //left  -> left pointer (start of string)

        for (int right = 0, left = 0; right < s.length(); right++) {
            char tempChar = s.charAt(right);
            if (visitedChars.containsKey(tempChar) && visitedChars.get(tempChar) >= left) {
                left = visitedChars.get(tempChar) + 1;
            }
            visitedChars.put(tempChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
            System.out.println(visitedChars);

        }
        return maxLen;
    }
}

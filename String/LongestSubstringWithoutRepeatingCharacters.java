package String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        for(char x:s.toCharArray()){
            System.out.println(set);
            set.add(x);
        }
        return set.size();
    }
}

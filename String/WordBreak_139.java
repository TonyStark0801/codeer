package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WordBreak_139 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        boolean result = solution.wordBreak(s, wordDict);
        System.out.println(result);
    }


}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<Character, List<String>> dict  = new HashMap<>();
        List<String> memory  = new ArrayList<>();
        for(String x : wordDict){
            Character letter = x.charAt(0);
           List<String> mem = dict.get(letter);
           if (mem == null) mem = new ArrayList<>();
           mem.add(x);
           dict.put(letter,mem);
        }


//        for(int i=0;i<s.length();i++){
//            if(!dict.containsKey(x)) return false;
//
//            List<String> matchedItems = dict.get(x);
//            for
//
//        }
        return false;
    }
}


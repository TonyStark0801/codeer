package String;

/**
 * <h2>424. Longest Repeating Character Replacement<h2/>
 * <p>
 * Medium
 * <p>
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <p>
 * Example 1:
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * <p>
 * Example 2:
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exist other ways to achieve this answer too.
 * <p>
 * Constraints:
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {
        String[] s = {"ABAB", "AABABBA"};
        int[] k = {2, 1};

        LongestRepeatingCharacterReplacement424 solution = new LongestRepeatingCharacterReplacement424();
        for (int i = 0; i < s.length; i++) {
            System.out.println(solution.characterReplacement(s[i], k[i]));
        }
    }

    public int characterReplacement(String s, int k) {
        if (s.length() <= 1) return s.length();
        int i ,j;
        i =  j = 0;
        int encodingCounter = 0;
        StringBuilder res = new StringBuilder();
        while (j<s.length()){
            if(s.charAt(i) == s.charAt(j)){
                encodingCounter++;
            }
            else {
                res.append(encodingCounter);
                res.append(s.charAt(i));
                encodingCounter=1;
                i=j;
            }
            j++;
        }
        System.out.println(res);
        return 0;
    }
}

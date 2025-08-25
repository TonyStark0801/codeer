package strings;

public class CountPalindromicSubstring {
    public static void main(String[] args) {
        String str = "12321";
        int count = countPalindromicSubstrings(str);
        System.out.println("Total palindromic substrings: " + count);
    }

    public static int countPalindromicSubstrings(String s) {
        int length = s.length();
        int left = 0;
        int right = 0;
        int counter = 0;
        while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            counter++;
        }

        return counter;
    }


}

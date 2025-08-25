package strings;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "AAA";
        System.out.println(isPalindrome(s,0,s.length()-1));
    }
    public static boolean isPalindrome(String s,int i,int j) {
        if(i==j ) return true;
        while (i < j) {
            char charAtIndexI = toLower(s.charAt(i));
            char charAtIndexJ = toLower(s.charAt(j));
            if (isNotValidCharacter(charAtIndexI)) {
                i++;
                continue;
            }
            if (isNotValidCharacter(charAtIndexJ)) {
                j--;
                continue;
            }
            if (charAtIndexI != charAtIndexJ) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isNotValidCharacter(char x) {
        return (x < 'a' || x > 'z') && (x < '0' || x > '9');
    }

    public static char toLower(char x) {
        if (x >= 'A' && x <= 'Z') return (char) (x + 32);
        return x;
    }
}

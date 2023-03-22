package Medium;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class M5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int maxLength = 0;
        String maxString = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= i; --j) {
                String current = s.substring(i, j + 1);
                if(j - i + 1 > maxLength && isPalindrome(current)) {
                    maxString = current;
                    maxLength = j - i + 1;
                }
            }
        }
        return maxString;
    }

    public boolean isPalindrome(String s) {

        int length = s.length();
        for(int i = 0; i <= length/2; ++i) {
            if(s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        M5 m5 = new M5();
        System.out.println(m5.longestPalindrome("b"));
    }

}

package Medium;

import java.util.HashSet;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class M3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        for(int i = 0; i < s.length(); ++i) {
            HashSet<Character> hashSet = new HashSet<Character>();
            char current = s.charAt(i);
            hashSet.add(current);
            int j = i + 1;
            for(; j < s.length(); ++j) {
                if(hashSet.contains(s.charAt(j))) {
                    break;
                }
                else{
                    hashSet.add(s.charAt(j));
                }
            }
            maxLength = Math.max(j - i, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        M3 m3 = new M3();
        System.out.println(m3.lengthOfLongestSubstring("abcabcbb"));
    }
}


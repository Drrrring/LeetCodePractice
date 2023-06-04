package Medium;

/**
 * 516. 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class M516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        // 矩阵中dp[i][j]标识下表从i到j中最长回文串的长度
        // dp[i][i] = 1
        // 若dp[i] = dp[j] 则dp[i][j] = dp[i+1][j-1] + 2
        // 若dp[i] != dp[j] 则dp[i][j] = max(dp[i+1][j], dp[i][j-1])
        int[][] dp = new int[s.length()][s.length()];
        for (int gap = 1; gap < s.length(); gap++) {
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = 1;
                int j = i + gap;
                if (j >= s.length()) break;
                if (j == i + 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        M516 m516 = new M516();
        System.out.println(m516.longestPalindromeSubseq("bbbab"));
    }
}

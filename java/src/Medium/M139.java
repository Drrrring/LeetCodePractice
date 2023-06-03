package Medium;

import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class M139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        // 数组dp保存字串(0,i)是否可以用字典拼出
        // dp[j] = dp[i] && substring(i+1, j)可以用字典拼出
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 对于任一字符串s，单词的分割点是未知的，所以需要遍历所有情况
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (dp[i] && wordDictSet.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        boolean[] booleans = new boolean[3];
        for (boolean b : booleans) {
            System.out.println(b);
        }
    }
}

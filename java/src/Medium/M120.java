package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class M120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            dp.add(new ArrayList<>(i + 1));
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    dp.get(i).add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                } else if (j < i){
                    int val = Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j));
                    dp.get(i).add(val + triangle.get(i).get(j));
                } else {
                    dp.get(i).add(dp.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++) {
            res = Math.min(res, dp.get(dp.size() - 1).get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        M120 m120 = new M120();
    }
}

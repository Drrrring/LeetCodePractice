package Medium;

import java.util.Collections;

/**
 * 740. 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class M740 {
    public int deleteAndEarn(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] temp = new int[max + 1];
        for (int n : nums) {
            temp[n] += n;
        }
        int[] dp = new int[max + 1];
        if (temp.length == 1) return 0;
        if (temp.length == 2) return temp[1];
        dp[0] = temp[0];
        dp[1] = temp[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + temp[i]);
        }
        return Math.max(dp[max], dp[max - 1]);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,4,5,5,5,6};
        M740 m740 = new M740();
        System.out.println(m740.deleteAndEarn(nums));
    }
}

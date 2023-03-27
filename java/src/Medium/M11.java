package Medium;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 */
public class M11 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while(j > i) {
            if (height[i] > height[j]) {
                max = Math.max(max, (j - i) * height[j]);
                --j;
            }
            else {
                max = Math.max(max, (j - i) * height[i]);
                ++i;
            }

        }

        return max;
    }

    public static void main(String[] args) {
        M11 m11 = new M11();
        System.out.println(m11.maxArea(new int[]{1, 1}));
    }
}

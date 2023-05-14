package Medium;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 */

public class M16 {
    // 时间复杂度: O(n^3)
//    public int threeSumClosest(int[] nums, int target) {
//        if(nums.length < 3) return 0;
//        int res = nums[0] + nums[1] + nums[2];
//
//        for(int i = 0; i < nums.length - 2; ++i){
//            for(int j = i + 1; j < nums.length - 1; ++j){
//                for(int k = j + 1; k < nums.length; ++k){
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if(Math.abs(target - res) > Math.abs(target - sum)){
//                        res = sum;
//                    }
//                }
//            }
//        }
//        return res;
//    }

    //思路同15，用双指针，时间复杂度：O(n^2)
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return 0;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                ++i;
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - res) > Math.abs(target - sum)){
                        res = sum;
                    }
                if(sum < target) {
                    ++j;
                    while(j < k && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                } else if (sum > target) {
                    --k;
                    while(j < k && nums[k] == nums[k + 1]) {
                        --k;
                    }
                }
                else {
                    return sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        M16 m16 = new M16();
        System.out.println(m16.threeSumClosest(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }
}

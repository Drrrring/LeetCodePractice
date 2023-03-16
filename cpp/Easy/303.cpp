//
// Created by y6655 on 2023/3/16.
//
/**
 * 303. 区域和检索 - 数组不可变
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * 1. NumArray(int[] nums) 使用数组 nums 初始化对象
 * 2. int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的总和 ，
 * 包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
*/

#include <vector>
using namespace std;
class NumArray {
public:
    vector<int> nums;
    NumArray(vector<int>& nums) {
        this->nums.assign(nums.begin(), nums.end());
    }

    int sumRange(int left, int right) {
        int sum = 0;
        if(left < 0 || right >= nums.size()) return 0;
        for(int i = left; i <= right; ++i){
            sum += nums[i];
        }
        return sum;
    }
};

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray* obj = new NumArray(nums);
 * int param_1 = obj->sumRange(left,right);
 */
//
// Created by y6655 on 2022/9/21.
//
/**
 * 268. 丢失的数字
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 */
#include <vector>
#include <algorithm>

using namespace std;
class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        for(int i = 0; i < nums.size(); ++i){
            if(i != nums[i]) return i;
        }
        return nums.size();
    }
};
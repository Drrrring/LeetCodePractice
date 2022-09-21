//
// Created by y6655 on 2022/9/21.
//
/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
#include <vector>
using namespace std;
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int zeroNum = 0;
        for(int i = 0; i < nums.size(); ++i){
            if(nums[i] == 0) zeroNum++;
            else if(zeroNum != 0){
                nums[i-zeroNum] = nums[i];
                nums[i] = 0;
            }
        }
    }
};


// 1 0 0 2
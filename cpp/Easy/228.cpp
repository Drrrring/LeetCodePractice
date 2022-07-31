//
// Created by y6655 on 2022/7/30.
//
/**
 * 228.汇总区间
 * 给定一个无重复元素的有序整数数组nums 。
 * 返回恰好覆盖数组中所有数字的最小有序区间范围列表。也就是说，nums的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于nums的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 注：nums 按升序排列
 */

#include <vector>
#include <string>
#include <iostream>
using namespace std;
class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        vector<string> v;
        if(nums.empty())
            return v;
        if(nums.size() == 1){
            v.push_back(to_string(nums[0]));
            return v;
        }

        int start = nums[0];
        for(int i = 1; i < nums.size(); ++i){

            if(nums[i] != nums[i-1] + 1){
                if(start == nums[i-1]){
                    v.push_back(to_string(start));
                }
                else{
                    v.push_back(to_string(start) + "->" + to_string(nums[i-1]));
                }
                start = nums[i];
            }
            if(i == nums.size() - 1){
                if(start == nums[i]){
                    v.push_back(to_string(start));
                }
                else{
                    v.push_back(to_string(start) + "->" + to_string(nums[i]));
                }
                break;
            }
        }
        return v;
    }
};

int main(){
    vector v = {0,2,3,5};
    Solution s;
    vector ss = s.summaryRanges(v);
    for(string str: ss){
        cout << str << " ";
    }
}
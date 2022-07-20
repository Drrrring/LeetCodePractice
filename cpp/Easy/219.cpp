//
// Created by y6655 on 2022/7/20.
//

/**
 * 219.存在重复元素II
 * 给你一个整数数组nums 和一个整数k ，判断数组中是否存在两个不同的索引i和j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。
 * 如果存在，返回 true ；否则，返回 false 。
 */

#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        //以下方法超时了
//        for(int i = 0; i < nums.size() - 1; i++){
//            for(int j = i + 1; j < nums.size(); j++){
//                if(nums[i] == nums[j] && j - i <= k)
//                    return true;
//            }
//        }
//        return false;

        unordered_map<int, int> map;
        for(int i = 0; i < nums.size(); ++i){
            auto it = map.find(nums[i]);
            if(it == map.end()){
                auto tmp = nums[i];
                map.insert({tmp, i});
            }
            else if(i - it->second <= k){
                return true;
            }
            else{
                map.insert_or_assign(nums[i], i);
            }
        }
        return false;
    }
};

int main(){
    Solution s;
    vector v = {1,2,3,1,2,3};
    cout << s.containsNearbyDuplicate(v, 3);
}
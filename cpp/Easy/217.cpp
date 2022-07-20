//
// Created by y6655 on 2022/7/20.
//
/**
 * 217.存在重复元素
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */

#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> set;
        for(int num: nums){
            if(set.find(num) != set.end()){
                return true;
            }
            else{
                set.insert(num);
            }
        }
        return false;
    }
};

int main(){
    Solution s;
    vector v = {1,2,3,5};
    cout << s.containsDuplicate(v);
}
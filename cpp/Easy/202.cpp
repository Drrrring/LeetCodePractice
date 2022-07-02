//
// Created by y6655 on 2022/7/2.
//

/**
 * 202.快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 快乐数定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 */

#include <iostream>
#include <unordered_set>
using namespace std;

class Solution {
public:
    bool isHappy(int n) {
        unordered_set<int> set;
        int bitSquareSum = n;
        set.insert(bitSquareSum);

        while(bitSquareSum != 1){
            bitSquareSum = getBitSquareSum(bitSquareSum);
            if (set.find(bitSquareSum) != set.end()) return false;
            set.insert(bitSquareSum);
        }

        return true;
    }

    int getBitSquareSum(int n){
        int res = 0;
        for(int i = n; i > 0; i /= 10){
            int bitNum = i % 10;
            res += bitNum * bitNum;
        }
        return res;
    }
};

int main(){
    Solution s;
    cout << s.isHappy(2);
}

/**
 * 关键：任意给定范围内的任意数的每一数位的平方和是有界的，不会趋向于无穷大
 */
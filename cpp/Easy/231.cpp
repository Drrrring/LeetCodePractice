//
// Created by y6655 on 2022/7/31.
//
/**
 * 231.2的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得n == 2^x ，则认为 n 是 2 的幂次方。
 */

#include <iostream>

class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n < 1)
            return false;
        for (int i = n; i > 1; i /= 2) {
            if (i % 2)
                return false;
        }
        return true;
    }

    //另一种解法： 若 n & (n-1) == 0，则n为2的幂
    //因为当且仅当 n只有最高位为1时，n为2的幂
    bool isPower(int n) {
        return !(n & (n - 1));
    }
};

int main() {
    Solution s;
    std::cout << s.isPowerOfTwo(1);
    std::cout << s.isPower(4);
}
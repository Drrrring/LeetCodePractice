//
// Created by y6655 on 2022/6/28.
//
#include <iostream>
#include <cstdint>
#include <string>
/**
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 输入: 00000010100101000001111010011100
 * 输出: 964176192 (00111001011110000010100101000000)
 *
*/

using namespace std;
class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        string reverse = "";
        for(uint32_t i = n; i > 0; i /= 2){
            uint32_t remainder = i % 2;
            reverse += (remainder + '0');
        }

        // 在后面补0至32位（也就是在倒置前的数前补0），防止倒置后数值变小
        int length = reverse.length();
        for(int i = 0; i < 32 - length; ++i){
            reverse += '0';
        }

        uint32_t res = 0;
        for(char c: reverse){
            res = 2 * res + (c - '0');
        }

        return res;
    }
};

int main(){
    Solution s;
//    uint32_t n = (uint32_t)(00000010100101000001111010011100);
    std::cout << s.reverseBits(43261596);
}
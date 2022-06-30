//
// Created by y6655 on 2022/6/30.
//

#include <cstdint>
#include <iostream>
#include <string>

/**
* 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 输入：00000000000000000000000000001011
 * 输出：3
*/

using namespace std;
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res = 0;
        for(uint32_t i = n; i > 0; i /= 2){
            int remainder = i % 2;
            if(remainder == 1){
                res++;
            }
        }

        return res;
    }
};

int main(){
    Solution s;
    cout << s.hammingWeight(11);
}
//
// Created by y6655 on 2022/9/19.
//
/**
 * 258. 各数相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 */

#include <iostream>
class Solution {
public:
    int addDigits(int num) {
        int res = 0;
        while(num > 0){
            res += num % 10;
            num /= 10;
        }
        if(res < 10) return res;
        else return addDigits(res);
    }
};

int main(){
    Solution s;
    std::cout << s.addDigits(258);
}
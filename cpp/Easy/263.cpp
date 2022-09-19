//
// Created by y6655 on 2022/9/19.
//
/**
 * 263.丑数
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false
 */
#include <iostream>
class Solution {
public:
    bool isUgly(int n) {
        int flag = 0;
        while(n > 1){
            if(n % 2 == 0){
                n /= 2;
                ++flag;
            }
            if(n % 3 == 0){
                n /= 3;
                ++flag;
            }
            if(n % 5 == 0){
                n /= 5;
                ++flag;
            }
            if(flag == 0) break;
            else{
                flag = 0;
            }
        }
        return n == 1;
    }
};

int main(){
    Solution s;
    std::cout << s.isUgly(21);
}
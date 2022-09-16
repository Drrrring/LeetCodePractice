//
// Created by y6655 on 2022/8/8.
//
/**
 * 242.有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。

 */
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
class Solution {
public:
    bool isAnagram(string s, string t) {
        if(s.length() != t.length()) return false;

        std::unordered_map<char,int> map;
        for(int i = 0; i < s.length(); ++i){
            auto spair = map.find(s[i]);
            if(spair == map.end()){
                map.insert({s[i], 1});
            }
            else{
                spair->second++;
            }
            auto tpair = map.find(t[i]);
            if(tpair == map.end()){
                map.insert({t[i], -1});
            }
            else{
                tpair->second--;
            }
        }

        for(auto pair: map){
            if(pair.second != 0) return false;
        }

        return true;
    }


};

int main(){
    Solution s;
    std::cout << s.isAnagram("anagram", "nagaram");
}
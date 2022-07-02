//
// Created by y6655 on 2022/7/2.
//

/**
 * 205.同构字符串
 * 给定两个字符串s和t，判断它们是否是同构的。
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 输入：s = "foo", t = "bar"
 * 输出：false
 */

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if(s.length() != t.length()) return false;

        unordered_map<char, char> s2tMap;
        unordered_map<char, char> t2sMap;
        for(int i = 0; i < s.length(); ++i){
            if(s2tMap.find(s[i]) == s2tMap.end() && t2sMap.find(t[i]) == t2sMap.end()){
                s2tMap[s[i]] = t[i];
                t2sMap[t[i]] = s[i];
            }
//            else if(s2tMap.find(s[i]) == s2tMap.end() && t2sMap.find(t[i]) != t2sMap.end() ||
//                    s2tMap.find(s[i]) != s2tMap.end() && t2sMap.find(t[i]) == t2sMap.end()) {
//                return false;
//            }
            else if(s2tMap[s[i]] != t[i] || t2sMap[t[i]] != s[i]){
                return false;
            }
        }

        return true;
    }
};

int main(){
    Solution s;
    cout << s.isIsomorphic("badc", "baba") << endl;

}

/**
 * 1. 两个字母均没有出现过
 * 2. 一个出现过，另一个没有出现过（肯定return false）
 * 3. 两个均出现过（看对应字母是否相等）
 */
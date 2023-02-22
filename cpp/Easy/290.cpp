//
// Created by y6655 on 2022/9/21.
//
/**
 * 290. 单词规律
 * 给定一种规律 pattern和一个字符串s，判断 s是否遵循相同的规律。
 * 这里的遵循指完全匹配，例如，pattern里的每个字母和字符串s中的每个非空单词之间存在着双向连接的对应规律。
 */
#include <string>
#include <vector>
#include <unordered_map>
using namespace std;
class Solution {
public:

    bool wordPattern(string pattern, string s) {
        vector<string> words;
        mySplit(s, words);

        if(words.size() != pattern.size())
            return false;
        unordered_map<char, string> mapa;
        unordered_map<string, char> mapb;

        for(int i = 0; i < pattern.size(); ++i){
            auto pa = mapa.find(pattern[i]);
            if(pa == mapa.end()){
                mapa.insert({pattern[i], words[i]});
            }
            else{
                if(pa->second != words[i])
                    return false;
            }

            auto pb = mapb.find(words[i]);
            if(pb == mapb.end()){
                mapb.insert({words[i], pattern[i]});
            }
            else{
                if(pb->second != pattern[i])
                    return false;
            }
        }
        return true;
    }

    void mySplit(string input, vector<string>& vec, char delim = ' '){
        int pos = input.find_first_of(delim);
        int off = 0;
        while(pos != string::npos){

            string word = input.substr(off, pos-off);
            vec.push_back(word);
            off = pos + 1;
            pos = input.find_first_of(delim, off);

        }
        string word = input.substr(off);
        vec.push_back(word);
    }


};

#include <iostream>
int main(){
    Solution s;
//    vector<string> test;
//    s.mySplit("abcd abcd abc", test);
//    for(auto s : test){
//        cout << s << ' ';
//    }
    cout << s.wordPattern("aba", "cat cat cat");
}
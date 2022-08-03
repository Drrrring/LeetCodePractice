//
// Created by y6655 on 2022/8/3.
//
/**
 * 234.回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

#include <iostream>
#include <vector>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    bool isPalindrome(ListNode *head) {
        vector<int> v;
        for(ListNode* current = head; current != nullptr; current = current->next){
            v.push_back(current->val);
        }

        int s = v.size();
        for(int i = 0; i < s/2; ++i){
            if(v[i] != v[s-1-i])
                return false;
        }
        return true;
    }
};
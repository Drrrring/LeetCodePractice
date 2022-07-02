//
// Created by y6655 on 2022/7/2.
//

/**
 * 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 */

#include <iostream>
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
    ListNode* reverseList(ListNode* head) {
        ListNode* res = nullptr;
        for(ListNode* current = head; current != nullptr; current = current->next){
            res = new ListNode(current->val, res);
        }
        return res;
    }
};
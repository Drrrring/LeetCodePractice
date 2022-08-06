//
// Created by y6655 on 2022/8/6.
//
/**
 * 237.删除链表中的节点
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点 不是末尾节点 。
 */

#include <iostream>

struct ListNode {
    int val;
    ListNode *next;

    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void deleteNode(ListNode *node) {
        //从待删除节点开始将每一个节点的val改成下一个节点的val，这种思路不好
//        ListNode *current = node;
//        ListNode *next = current->next;
//        ListNode *nextNext = next->next;
//        while (next != nullptr) {
//            current->val = next->val;
//            if (nextNext == nullptr) {
//                current->next = nullptr;
//                return;
//            }
//            current = current->next;
//            next = current->next;
//            nextNext = next->next;
//        }

        //答案的思路：将待删除节点的val改成下一个节点的val，并删除下一个节点
        node->val = node->next->val;
        node->next = node->next->next;
    }
};
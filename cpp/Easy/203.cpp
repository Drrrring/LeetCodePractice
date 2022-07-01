//
// Created by y6655 on 2022/7/1.
//

/**
 * 203.移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点 。
 */

/**
 * Definition for singly-linked list.
 */
struct ListNode {
    int val;
    ListNode *next;

    ListNode() : val(0), next(nullptr) {}

    ListNode(int x) : val(x), next(nullptr) {}

    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution {
public:
    ListNode *removeElements(ListNode *head, int val) {
        if (head == nullptr) return head;

        ListNode *previous = head;
        ListNode *current = head->next;
        while (head->val == val) {
            if (current == nullptr) return nullptr;
            previous = current;
            current = current->next;
            head = previous;
        }

        while (current != nullptr) {
            if (current->val == val) {
                ListNode *toDelete = current;
                previous->next = toDelete->next;
//                delete toDelete;
                current = toDelete->next;
            } else {
                previous = current;
                current = current->next;
            }
        }

        return head;
    }
};
//
// Created by y6655 on 2022/8/4.
//
/**
 * 235.二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */

#include <iostream>
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class Solution {
public:
    TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
        TreeNode* current = root;
        while(true){
            if(current->val > p->val && current->val < q->val || current->val < p->val && current->val > q->val)
                return current;
            if(current->val == p->val || current->val == q->val)
                return current;
            if(current->val > p->val && current->val > q->val){
                current = current->left;
            }
            if(current->val < p->val && current->val < q->val){
                current = current->right;
            }
        }
    }
};
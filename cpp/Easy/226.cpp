//
// Created by y6655 on 2022/7/26.
//
/**
 * 226.翻转字符串
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */

#include <queue>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    TreeNode *invertTree(TreeNode *root) {
        if (root == nullptr)
            return root;

        queue<TreeNode *> q;
        q.push(root);
        while(!q.empty()){
            TreeNode* current = q.front();
            q.pop();
            if(current->left != nullptr)
                q.push(current->left);
            if(current->right != nullptr)
                q.push(current->right);

            TreeNode temp(current->val, current->left, current->right);
            current->left = temp.right;
            current->right = temp.left;
        }

        return root;
    }
};

int main() {
    TreeNode t1(1);
    TreeNode t2(2);
    TreeNode t3(3);
    TreeNode t4(4);
    TreeNode t5(5);
    TreeNode t6(6);
    TreeNode t7(7);
    t1.left = &t2;
    t1.right = &t3;
    t2.left = &t4;
    t2.right = &t5;
    t3.left = &t6;
//    t3.right = &t7;

    Solution s;
    s.invertTree(&t1);
}

//
// Created by y6655 on 2022/9/18.
//
/**
 * 257. 二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。叶子节点 是指没有子节点的节点。
 */

#include <string>
#include <vector>
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
    vector <string> binaryTreePaths(TreeNode *root) {
        vector<string> result;
        if(root == nullptr) return result;
        string s = to_string(root->val);
        buildPath(s, root, result);
        return result;
    }

    void buildPath(string path, TreeNode* pnode, vector<string>& res){
//        if(pnode == nullptr) return path;
//        path += "->" + to_string(pnode->val);
        if(pnode->left != nullptr){
            string LPath = path + "->" + to_string(pnode->left->val);
            buildPath(LPath, pnode->left, res);
        }
        if(pnode->right != nullptr){
            string RPaht = path + "->" + to_string(pnode->right->val);
            buildPath(RPaht, pnode->right, res);
        }
        if(pnode->left == nullptr && pnode->right == nullptr){
            res.push_back(path);
        }
    }
};
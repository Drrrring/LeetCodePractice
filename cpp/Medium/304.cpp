//
// Created by y6655 on 2023/3/16.
//
/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * 1. NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * 2. int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
*/

#include <vector>
#include <iostream>
using namespace std;
class NumMatrix {
public:
    vector<vector<int>>* pm;
    NumMatrix(vector<vector<int>>& matrix) {
        int length = matrix.size();
        pm = new vector<vector<int>>(length);
        auto m = *pm;
        for (int i = 0; i < length; ++i) {
            m[i].assign(matrix[i].begin(), matrix[i].end());
        }
    }

    int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        auto m = *pm;
        if(row1 < 0 || col1 < 0 || row2 >= m.size() || col2 >= m[0].size()) return 0;
        for(int i = row1; i <= row2; ++i) {
            for(int j = col1; j <= col2; ++j) {
                sum += m[i][j];
            }
        }
        return sum;
    }
};

int main(){
    vector<vector<int>> m = {{1,2},{3,4}};
    NumMatrix* numMatrix = new NumMatrix(m);
    cout << numMatrix->sumRegion(0,0,1,1);

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix* obj = new NumMatrix(matrix);
 * int param_1 = obj->sumRegion(row1,col1,row2,col2);
 */
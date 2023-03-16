package Medium;

/**
 * 304. 二维区域和检索 - 矩阵不可变
 * 给定一个二维矩阵 matrix，以下类型的多个请求：
 *
 * 计算其子矩形范围内元素的总和，该子矩阵的 左上角 为 (row1, col1) ，右下角 为 (row2, col2) 。
 * 实现 NumMatrix 类：
 * 1. NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化
 * 2. int sumRegion(int row1, int col1, int row2, int col2) 返回 左上角 (row1, col1) 、右下角 (row2, col2) 所描述的子矩阵的元素 总和 。
 */
public class M304 {
    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][]{{1, 2}, {3, 4}});
        System.out.println(numMatrix.sumRegion(1,1,1,1));
    }
}

class NumMatrix {
    public int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        if(row1 < 0 || col1 < 0 || row2 >= matrix.length || col2 >= matrix[0].length) return 0;
        for(int i = row1; i <= row2; ++i) {
            for(int j = col1; j <= col2; ++j) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
package Medium;

/**
 * 221. 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class M221 {
    //暴力法
//    public int maximalSquare(char[][] matrix) {
//        int size = 0;
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return size;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '1') {
//                    size = Math.max(size, 1);
//                    int maxSize = Math.min(m - i, n - j);
//
//                    for (int currentSize = 1; currentSize < maxSize; currentSize++) {
//                        boolean flag = true;
//                        for (int k = 0; k <= currentSize; k++) {
//                            if(matrix[currentSize + i][k + j] == '0' || matrix[k + i][currentSize + j] == '0'){
//                                flag = false;
//                                break;
//                            }
//                        }
//                        if (flag) {
//                            size = Math.max(size, currentSize + 1);;
//                        } else {
//                            break;
//                        }
//                    }
//
//                }
//            }
//        }
//        return size * size;
//    }

    //动态规划
    public int maximalSquare(char[][] matrix) {
        // 矩阵dp记录以(i,j)为右下角顶点的正方形的边长
        // 若matrix[i][j] == 0 则 dp[i][j] == 0
        // 若matrix[i][j] == 1 则 dp[i][j] == min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
        int size = dp[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if(i == 0 || j == 0){
                        dp[i][j] = 1;
                    }
                    else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    size = Math.max(size, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return size * size;
    }

    public static void main(String[] args) {
//        char[][] chars = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] chars = {{'0', '1'}, {'1', '0'}};
        M221 m221 = new M221();
        System.out.println(m221.maximalSquare(chars));
    }
}

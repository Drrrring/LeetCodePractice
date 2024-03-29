package Medium;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class M63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 矩阵dp保存到达点(i,j)的路径数
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1 ^ obstacleGrid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = (1 ^ obstacleGrid[i][0]) & dp[i-1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = (1 ^ obstacleGrid[0][i]) & dp[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,0}};
        M63 m63 = new M63();
        System.out.println(m63.uniquePathsWithObstacles(ints));
    }
}

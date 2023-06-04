package Medium;

import java.util.Stack;

/**
 * 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
 */
public class M547 {
    // 这里是题目理解错了，以为所有相邻的1算一个省份
    // 深度优先搜索
//    public int findCircleNum(int[][] isConnected) {
//        int res = 0;
//        int n = isConnected.length;
//        Stack<Location> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (isConnected[i][j] == 1) {
//                    res++;
//                    stack.push(new Location(i, j));
//                    while (!stack.empty()) {
//                        Location current = stack.pop();
//                        int r = current.row;
//                        int c = current.column;
//                        isConnected[r][c] = 2;
//                        if (r - 1 >= 0 && isConnected[r - 1][c] == 1) stack.push(new Location(r - 1, c));
//                        if (c - 1 >= 0 && isConnected[r][c - 1] == 1) stack.push(new Location(r, c - 1));
//                        if (r + 1 < n && isConnected[r + 1][c] == 1) stack.push(new Location(r + 1, c));
//                        if (c + 1 < n && isConnected[r][c + 1] == 1) stack.push(new Location(r, c + 1));
//                    }
//                }
//            }
//        }
//        return res;
//    }
//
//    class Location {
//        public int row;
//        public int column;
//
//        public Location(int row, int column) {
//            this.row = row;
//            this.column = column;
//        }
//    }

    // 深度优先搜索
    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if(isConnected[i][j] == 1) {
                    res++;
                    isConnected[j][i] = 2;
                    Stack<Integer> stack = new Stack<>();
                    stack.push(j);
                    while(!stack.empty()) {
                        int row = stack.pop();
                        for (int k = 0; k < length; k++) {
                            if (isConnected[row][k] == 1) {
                                isConnected[row][k] = 2;
                                isConnected[k][row] = 2;
                                stack.push(k);
                            }
                        }
                    }

                }
            }
        }
        return res;
    }
}

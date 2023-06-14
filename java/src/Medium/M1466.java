package Medium;

import java.util.*;

/**
 * 1466. 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 */
public class M1466 {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        HashMap<Integer, List<Integer>> toDestination = new HashMap<>();
        HashMap<Integer, List<Integer>> toSource = new HashMap<>();
        for (int[] connection : connections) {
            int a = connection[0], b = connection[1];
            toDestination.putIfAbsent(a, new ArrayList<>());
            toDestination.get(a).add(b);
            toSource.putIfAbsent(b, new ArrayList<>());
            toSource.get(b).add(a);
        }
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.empty()) {
            int current = stack.pop();
            visited[current] = true;
            if (toSource.containsKey(current)) {
                for (int city : toSource.get(current)) {
                    if (!visited[city]) stack.push(city);
                }
            }
            if (toDestination.containsKey(current)) {
                for (int city : toDestination.get(current)) {
                    if (!visited[city]){
                        ++res;
                        stack.push(city);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        M1466 m1466 = new M1466();
        System.out.println(m1466.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
        System.out.println(m1466.minReorder(5, new int[][]{{1, 0}, {2, 0}}));
    }
}

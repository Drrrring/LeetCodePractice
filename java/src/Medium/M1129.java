package Medium;

import java.util.*;

/**
 * 1129. 颜色交替的最短路径
 * 给定一个整数 n，即有向图中的节点数，其中节点标记为 0 到 n - 1。图中的每条边为红色或者蓝色，并且可能存在自环或平行边。
 * 给定两个数组 redEdges 和 blueEdges，其中：
 * redEdges[i] = [ai, bi] 表示图中存在一条从节点 ai 到节点 bi 的红色有向边，
 * blueEdges[j] = [uj, vj] 表示图中存在一条从节点 uj 到节点 vj 的蓝色有向边。
 * 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，那么 answer[x] = -1。
 */
public class M1129 {
    // 广度优先搜索
    // 注：自环的地方相当于可以变颜色
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        Arrays.fill(res, -1);
        boolean[][] visited = new boolean[n][2];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        queue.add(0);
        queue.add(0);
        queue.add(1);
        int length = -1;
        while (!queue.isEmpty()) {
            int size = queue.size() / 2;
            ++length;
            for (int i = 0; i < size; i++) {
                int node = queue.remove();
                int color = queue.remove();
                if (res[node] == -1) {
                    res[node] = length;
                } else {
                    res[node] = Math.min(res[node], length);
                }
                if (color == 0) {
                    visited[node][0] = true;
                    HashSet<Integer> nodes = findConnectedNodes(node, blueEdges);
                    for (int ns : nodes) {
                        if (!visited[ns][1]) {
                            queue.add(ns);
                            queue.add(1);
                        }
                    }
                } else {
                    visited[node][1] = true;
                    HashSet<Integer> nodes = findConnectedNodes(node, redEdges);
                    for (int ns : nodes) {
                        if (!visited[ns][0]) {
                            queue.add(ns);
                            queue.add(0);
                        }
                    }
                }
            }
        }
        return res;
    }

    HashSet<Integer> findConnectedNodes(int node, int[][] edges) {
        HashSet<Integer> connectedNodes = new HashSet<>();
        for (int[] tuple : edges) {
            if (tuple.length != 0) {
                if (tuple[0] == node) {
                    connectedNodes.add(tuple[1]);
                }
            }
        }
        return connectedNodes;
    }

    public static void main(String[] args) {
        M1129 m1129 = new M1129();
//        System.out.println(m1129.findConnectedNodes(1, new int[][]{{2, 1}, {1,3}}));
        System.out.println(Arrays.toString(m1129.shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{})));
    }

}

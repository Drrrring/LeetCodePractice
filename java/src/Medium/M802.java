package Medium;

import java.util.*;

/**
 * 802. 找到最终的安全状态
 * 有一个有 n 个节点的有向图，节点按 0 到 n - 1 编号。图由一个 索引从 0 开始 的 2D 整数数组 graph表示，
 * graph[i]是与节点 i 相邻的节点的整数数组，这意味着从节点 i 到 graph[i]中的每个节点都有一条边。
 * 如果一个节点没有连出的有向边，则该节点是 终端节点 。如果从该节点开始的所有可能路径都通向 终端节点 ，则该节点为 安全节点 。
 * 返回一个由图中所有 安全节点 组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 */
public class M802 {
    // 深度优先遍历 + 三色标记
    // color数组中，0：未遍历， 1：已遍历， 2：确认安全
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new ArrayList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (this.safe(graph, color, i)){
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    boolean safe(int[][] graph, int[] color, int node) {
        if (color[node] > 0) return color[node] == 2;
        color[node] = 1;
        for (int n : graph[node]) {
            if (!safe(graph, color, n)) {
                return false;
            }
        }
        color[node] = 2;
        return true;
    }

    public static void main(String[] args) {
        M802 m802 = new M802();
        int[][] graph = {{1, 2, 4}, {0, 2, 4}, {3, 4}, {4}, {2}};
        System.out.println(m802.eventualSafeNodes(graph));
    }
}

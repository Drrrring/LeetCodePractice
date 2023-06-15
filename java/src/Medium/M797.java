package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 */
public class M797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        stack.push(path);
        while (!stack.empty()) {
            List<Integer> currentPath = stack.pop();
            for (int next : graph[currentPath.get(currentPath.size() - 1)]) {
                List<Integer> newPath = new ArrayList<>(currentPath);
                newPath.add(next);
                if (next == n) {
                    res.add(newPath);
                } else {
                    stack.push(newPath);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        M797 m797 = new M797();
        System.out.println(m797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(m797.allPathsSourceTarget(new int[][]{{4,3,1},{3,2,4},{3},{4},{}}));

    }
}


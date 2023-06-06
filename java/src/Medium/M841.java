package Medium;

import java.util.List;
import java.util.Stack;

/**
 * 841. 钥匙和房间
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 */
public class M841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        visited[0] = true;
        while (!stack.empty()) {
            int current = stack.pop();
            visited[current] = true;
            for (int n : rooms.get(current)) {
                if (!visited[n]) {
                    stack.push(n);
                }
            }
        }
        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }
}

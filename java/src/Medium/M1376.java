package Medium;
import java.util.*;

/**
 * 1376. 通知所有员工所需的时间
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 */
public class M1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // 构建负责人的树，父节点是上司
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) continue;
            hashMap.putIfAbsent(manager[i], new ArrayList<>());
            hashMap.get(manager[i]).add(i);
        }
        int res = dfs(headID, informTime, hashMap);
        return res;
    }

    int dfs(int worker, int[] informTime, HashMap<Integer, List<Integer>> hashMap) {
        int time = informTime[worker];
        if (time == 0) return 0;
        int maxTime = 0;
        for (int w : hashMap.get(worker)) {
            maxTime = Math.max(maxTime, dfs(w, informTime, hashMap));
        }
        return time + maxTime;
    }

    public static void main(String[] args) {
        M1376 m1376 = new M1376();
        System.out.println(m1376.numOfMinutes(6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}));
    }
}

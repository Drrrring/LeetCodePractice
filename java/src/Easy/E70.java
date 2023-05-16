package Easy;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class E70 {
    // 递归 超时了
//    public int climbStairs(int n) {
//        if(n == 1) return 1;
//        else if(n == 2) return 2;
//        else {
//            return climbStairs(n-1) + climbStairs(n-2);
//        }
//    }

    // f(x) = f(x-1) + f(x-2) 滚动数组
    // f(0) = 1, f(1) = 1, f(2) = 1+1 = 2
    public int climbStairs(int n) {
        if(n == 1) return 1;
        // x,y,z分别指向 f(x-2), f(x-1), f(x)
        int x = 1, y = 1, z = 2;
        for (int i = 2; i < n; ++i) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }
    public static void main(String[] args) {
        E70 e70 = new E70();
        System.out.println(e70.climbStairs(45));
    }
}

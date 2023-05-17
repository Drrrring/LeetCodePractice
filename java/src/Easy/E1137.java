package Easy;

/**
 * 1137. 第 N 个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class E1137 {
    //滚动数组 同E70
    public int tribonacci(int n) {
        if(n < 2) {
            return n;
        }
        else if(n < 4) {
            return n - 1;
        }
        int x = 0, y = 1, z = 1, w = 2;
        for (int i = 3; i < n; i++) {
            x = y;
            y = z;
            z = w;
            w = x + y +z;
        }
        return w;
    }
}

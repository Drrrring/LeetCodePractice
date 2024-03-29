package Easy;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 */
public class E509 {
    // 思路同E70，用滚动数组
    public int fib(int n) {
        if(n < 2) return n;
        int x = 0, y = 1, z = 1;
        for (int i = 2; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return z;
    }
}

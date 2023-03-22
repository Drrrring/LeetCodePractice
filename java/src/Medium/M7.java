package Medium;

/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class M7 {
    public int reverse(int x) {
        int res = 0;
        for (int n = Math.abs(x); n > 0; n /= 10) {
            int end = n % 10;
            res = res * 10 + end;
            if (end != res % 10) {
                return 0;
            }
        }
        res = x >= 0 ? res : (-res);
        return res;
    }

    public static void main(String[] args) {
        M7 m7 = new M7();
        System.out.println(m7.reverse(1534236469));
    }
}

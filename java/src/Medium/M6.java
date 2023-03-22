package Medium;

/**
 * 6. N字形排列
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 */
public class M6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int numCols = s.length();
//        if(s.length() % numRows == 0) {
//            numCols = s.length() / numRows;
//        } else {
//            numCols = s.length() / numRows + 1;
//        }

        char[][] temp = new char[numRows][numCols];
//        String[] res = new String[numCols];
        int index = 0;
        for (int i = 0; i < numCols && index < s.length(); i++) {
            if (i % (numRows - 1) != 0) {
                temp[numRows - 1 - i % (numRows - 1)][i] = s.charAt(index); // 1,4
                index++;
                continue;
            }
            for (int j = 0; j < numRows && index < s.length(); j++) {
//                if (i % (numRows - 1) == 0 && index < s.length()) {
//                    temp[j][i] = s.charAt(index);
//                    index++;
//                } else if (index < s.length()) {
//                    temp[]
//                } else {
//                    temp[j][i] = ' ';
//                }
                temp[j][i] = s.charAt(index);
                index++;
            }

        }

        StringBuilder res = new StringBuilder();
        for (char[] chars : temp) {
            for (char c : chars) {
                if (c != 0) {
                    res.append(c);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        M6 m6 = new M6();
        System.out.println(m6.convert("PAYPALISHIRING", 4));
        //PAHNAPLSIIGYIR
        //"PINALSIGYAHRPI"
//        char[] chars = new char[10];
//        System.out.println(chars);
    }
}

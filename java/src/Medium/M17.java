package Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class M17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        res.add("");
        List<String> letters = new ArrayList<>(List.of(new String[]{"", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"}));
        List<Integer> indexs = new ArrayList<>();
        for (int i = 0; i < digits.length(); ++i) {
            indexs.add((digits.charAt(i) - '0'));
        }

        for (int i = 0; i < digits.length(); i++) {
            updateRes(res, letters.get(indexs.get(i)));
        }

        return res;
    }

    public void updateRes(List<String> res, String letters) {
        int length = letters.length();
        List<List<String>> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            temp.add(new ArrayList<>(res));
            for (int j = 0; j < temp.get(i).size(); ++j) {
                String value = temp.get(i).get(j) + letters.charAt(i);
                temp.get(i).set(j, value);
            }
        }
        res.clear();
        for (List<String> strings : temp) {
            res.addAll(strings);
        }
    }

    public static void main(String[] args) {
        M17 m17 = new M17();
        System.out.println(m17.letterCombinations("23"));
//        List<Integer> a = new ArrayList<>(List.of(1, 2, 3));
//        for (int i = 0; i < 3; i++) {
//            update(a, i + 10);
//        }
//
//        System.out.println(a);
    }

//    public static void update(List<Integer> a, int value) {
////        a.set(0, value);
//        a = new ArrayList<>();
//    }
}

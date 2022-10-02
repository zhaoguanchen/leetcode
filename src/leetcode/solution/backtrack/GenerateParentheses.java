package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        int nums = 3;
        System.out.println(generateParenthesis(nums));
    }

    private static int max;
    private final static List<String> list = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        max = n;
        backtrack(list, new StringBuilder(), 0, 0);
        return list;
    }


    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close) {
        // 当到达最终长度时，停止递归
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // 左括号数量小于结果长度一半时，可继续添加左括号
        if (open < max) {
            // 做选择
            cur.append("(");
            backtrack(ans, cur, open + 1, close);
            // 撤销
            cur.deleteCharAt(cur.length() - 1);
        }
        // 右括号数量小于左括号数量时，可以添加右括号
        if (close < open) {
            // 做选择
            cur.append(")");
            backtrack(ans, cur, open, close + 1);
            // 撤销
            cur.deleteCharAt(cur.length() - 1);
        }
    }

}

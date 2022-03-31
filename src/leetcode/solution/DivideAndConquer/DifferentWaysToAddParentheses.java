package leetcode.solution.DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. Different Ways to Add Parentheses
 */
public class DifferentWaysToAddParentheses {

    public static void main(String[] args) {
        String exp = "2*3-4*5";
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        System.out.println(differentWaysToAddParentheses.diffWaysToCompute(exp));
        // -34,-14,-10,-10,10
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 检测运算符
            if ('+' == c || '-' == c || '*' == c) {
                // 处理运算符左边表达式
                String partLeftStr = expression.substring(0, i);
                List<Integer> partLeftAns = diffWaysToCompute(partLeftStr);
                // 处理运算符右边表达式
                String partRightStr = expression.substring(i + 1);
                List<Integer> partRightAns = diffWaysToCompute(partRightStr);
                // 组合所有情况
                for (int left : partLeftAns) {
                    for (int right : partRightAns) {
                        if ('+' == c) {
                            ans.add(left + right);
                        } else if ('-' == c) {
                            ans.add(left - right);
                        } else {
                            ans.add(left * right);
                        }
                    }

                }
            }


        }

        // 表达式中不存在运算符，返回数字
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }

        return ans;

    }
}
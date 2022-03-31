package leetcode.solution.other;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 227. Basic Calculator II
 */
public class BasicCalculatorII {


    public static void main(String[] args) {
        String s = "3+2*2";
        BasicCalculatorII calculator = new BasicCalculatorII();
        int ans = calculator.calculate(s);
        System.out.println(ans);
        // 7
    }

    public int calculate(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 跳过空格
            if (' ' == c) {
                continue;
            }
            deque.add(c);
        }

        return helper(deque);

    }


    private int helper(Deque<Character> deque) {
        // 初始符号
        char sign = '+';

        int num = 0;
        Stack<Integer> stack = new Stack<>();

        while (!deque.isEmpty()) {
            char c = deque.pollFirst();
            if (isDigit(c)) {
                num = 10 * num + (c - '0');
            }

            if (!isDigit(c) || deque.isEmpty()) {
                if (sign == '+') {
                    stack.add(num);
                }
                if (sign == '-') {
                    stack.add(-num);
                }
                if (sign == '*') {
                    int pre = stack.pop();
                    int res = pre * num;
                    stack.add(res);
                }
                if (sign == '/') {
                    int pre = stack.pop();
                    int res = pre / num;
                    stack.add(res);
                }
                sign = c;
                num = 0;
            }

        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }
}

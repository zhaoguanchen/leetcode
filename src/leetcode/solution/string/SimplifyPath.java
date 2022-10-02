package leetcode.solution.string;

import java.util.Stack;

/**
 * 71. Simplify Path
 */
public class SimplifyPath {


    public static void main(String[] args) {
        String path = "/home//foo/";
        SimplifyPath simplifyPath = new SimplifyPath();
        String ans = simplifyPath.simplifyPath(path);
        System.out.println(ans);
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pathArray = path.split("/");

        for (String item : pathArray) {
            // 空或者.可以忽略
            if (item.isEmpty() || ".".equals(item)) {
                continue;
            } else if ("..".equals(item)) {// 回退到上一级目录，相当于丢弃上一级目录内容
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {// 添加到栈
                stack.push(item);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 栈的for循环是从栈底往栈顶
        for (String item : stack) {
            stringBuilder.append("/");
            stringBuilder.append(item);
        }


        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }
}

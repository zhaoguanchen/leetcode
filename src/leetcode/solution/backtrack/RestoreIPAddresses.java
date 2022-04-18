package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> ans = restoreIPAddresses.restoreIpAddresses(s);
        System.out.println(ans);

    }

    private String str;

    List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        str = s;
        LinkedList<String> path = new LinkedList<>();
        backtrack(0, path);

        return ans;
    }


    private void backtrack(int index, LinkedList<String> path) {
        if (index > str.length() - 1) {
            return;
        }

        // 已经添加了3段，处理最后一段
        if (path.size() == 3) {
            String s = str.substring(index);
            if (!isAvailable(s)) {
                return;
            }
            path.add(s);
            String res = String.join(".", path);
            ans.add(res);
            path.removeLast();
        }


        for (int i = 0; i < 3; i++) {
            int endIndex = index + i;
            if (endIndex > str.length() - 1) {
                continue;
            }
            String s = str.substring(index, endIndex + 1);
            if (!isAvailable(s)) {
                continue;
            }
            // 做选择
            path.add(s);
            // 回溯
            backtrack(endIndex + 1, path);
            // 撤销选择
            path.removeLast();

        }


    }


    private boolean isAvailable(String s) {
        // 超长
        if (s.length() > 3) {
            return false;
        }
        // 数字不合法
        int value = getInt(s);
        if (value > 255) {
            return false;
        }

        if (s.length() > 1 && '0' == s.charAt(0)) {
            return false;
        }

        return true;
    }

    private int getInt(String s) {
        int ans = 0;
        int x = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans = ans + x * (s.charAt(i) - '0');
            x = x * 10;
        }
        return ans;
    }

}
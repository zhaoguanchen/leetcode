package leetcode.solution.DP;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. Decode Ways
 */
public class DecodeWays {


    public static void main(String[] args) {
        String s = "226";
        DecodeWays decodeWays = new DecodeWays();
        int ans = decodeWays.numDecoding(s);
        System.out.println(ans);
    }

    private String str;

    Map<Integer, Integer> memo = new HashMap<>();


    public int numDecoding(String s) {
        str = s;
        return helper(0);
    }

    private int helper(int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        // 末尾
        if (index == str.length()) {
            return 1;
        }
        // 首位为0 不可处理
        if (str.charAt(index) == '0') {
            return 0;
        }
        // 最后一位
        if (index == str.length() - 1) {
            return 1;
        }

        int ans = helper(index + 1);
        String subDoubleStr = str.substring(index, index + 2);
        int subDoubleVal = Integer.parseInt(subDoubleStr);
        if (subDoubleVal <= 26) {
            ans += helper(index + 2);
        }
        memo.put(index, ans);
        return ans;
    }


}
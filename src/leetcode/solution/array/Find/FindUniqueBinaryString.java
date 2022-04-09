package leetcode.solution.array.Find;

import java.util.Arrays;

/**
 * 1980. Find Unique Binary String
 */
public class FindUniqueBinaryString {

    public static void main(String[] args) {
        String[] nums = {"111", "011", "001"};
        FindUniqueBinaryString find = new FindUniqueBinaryString();
        System.out.println(find.findDifferentBinaryString(nums));
    }

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        // 判断只有一个数的情况
        if (nums.length == 1) {
            String str = nums[0];
            return "1".equals(str) ? "0" : "1";
        }

        for (int i = 0; i < n; i++) {
            String str = nums[i];
            int index = getInteger(str);
            if (index > n) {
                continue;
            }
            if (index == n) {
                nums[0] = "-" + nums[0];
            } else {
                nums[index] = "-" + nums[index];
            }
            System.out.println(Arrays.toString(nums));
        }

        for (int i = 0; i < n; i++) {
            String str = nums[i];
            if (!str.startsWith("-")) {
                return getBinaryString(i, n);
            }
        }

        return getBinaryString(n + 1, n);
    }

    /**
     * 二进制字符串转整数
     *
     * @param num
     * @return
     */
    private int getInteger(String num) {
        int base = 0;
        for (int i = 0; i < num.length(); i++) {
            int index = num.length() - 1 - i;
            char c = num.charAt(index);
            if ('1' == c) {
                base += Math.pow(2, i);
            }
        }

        return base;
    }

    /**
     * 整数转二进制字符串
     *
     * @param num
     * @param length
     * @return
     */
    private String getBinaryString(int num, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int base = (int) Math.pow(2, length - 1 - i);
            if (base <= num) {
                sb.append("1");
                num = num - base;
            } else {
                sb.append("0");
            }
        }

        return sb.toString();
    }
}

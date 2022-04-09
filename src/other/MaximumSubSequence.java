package other;

import java.util.Arrays;

/**
 * Google 某题
 */
public class MaximumSubSequence {

    public static void main(String[] args) {
        String s = "110110101";
        int n = 40;
        MaximumSubSequence c = new MaximumSubSequence();
        int ans = c.getLength(s, n);
        System.out.println(ans);
        // 6

        String s1 = "111101";
        int n1 = 13;
        int ans1 = c.getLength(s1, n1);
        System.out.println(ans1);
        // 6
        String s2 = "10010100";
        int n2 = 147;
        int ans2 = c.getLength(s2, n2);
        System.out.println(ans2);
        // 6
    }


    public int getLength(String s, int x) {
        char[] chars = s.toCharArray();
        // 结果标志，-1为默认值，未采纳，0代表采纳的值为0，1代表采纳的值为1
        int[] flag = new int[chars.length];

        // 默认值填充为-1
        Arrays.fill(flag, -1);

        // 采纳所有的0
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                flag[i] = 0;
            }
        }

        // 采纳第一个0前面的1
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] != -1) {
                if (i > 0) {
                    flag[i - 1] = 1;
                    break;
                }
            }
        }

        // 计算数值，如小于target，则从后往前补充1
        for (int i = chars.length - 1; i >= 0; i--) {
            if (getInteger(flag) > x) {
                break;
            }
            if (-1 == flag[i]) {
                flag[i] = 1;
            }
        }

        // 计算采纳值的个数
        int ans = 0;
        for (int j : flag) {
            if (-1 != j) {
                ans++;
            }
        }

        // 为什么减一  上面break的时候多赋了一个值
        return ans - 1;
    }


    /**
     * 二进制转整数
     *
     * @param
     * @return
     */
    private int getInteger(int[] flag) {
        int base = 0;
        int p = 0;
        for (int i = 0; i < flag.length; i++) {
            int index = flag.length - 1 - i;
            if (-1 == flag[index]) {
                continue;
            }
            if (1 == flag[index]) {
                base += Math.pow(2, p);
            }
            p++;
        }

        return base;
    }
}

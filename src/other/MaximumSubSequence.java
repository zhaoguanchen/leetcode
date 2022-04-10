package other;

import java.util.Arrays;

/**
 * Google 某题
 * 寻找对应的十进制数小于等于X的最长的二进制子序列
 */
public class MaximumSubSequence {

    public static void main(String[] args) {
        String s = "1101101010001110010101101";
        int n = 4000000;
        MaximumSubSequence c = new MaximumSubSequence();
        int ans = c.getLength(s, n);
        System.out.println(ans);
        // 22
        ans = c.getLength("110110101", 40);
        System.out.println(ans);
        // 6
        ans = c.getLength("110110101", 0);
        System.out.println(ans);
        // 0
        ans = c.getLength("110110101", 1);
        System.out.println(ans);
        // 1

        ans = c.getLength("110110101", 5);
        System.out.println(ans);
        // 3

        ans = c.getLength("101101", 98);
        System.out.println(ans);
        // 7

        ans = c.getLength("10110010", 2);
        System.out.println(ans);
        // 2

        ans = c.getLength("10110010", 3);
        System.out.println(ans);
        // 2


//        EXPECT_EQ(binaryMaxLength("110110101", 40), 6);
//        EXPECT_EQ(binaryMaxLength("110110101", 0), 0);
//        EXPECT_EQ(binaryMaxLength("110110101", 1), 1);
//        EXPECT_EQ(binaryMaxLength("110110101", 5), 3);
//        EXPECT_EQ(binaryMaxLength("101101", 198), 7);
//        EXPECT_EQ(binaryMaxLength("10110010", 2), 2);
//        EXPECT_EQ(binaryMaxLength("10010100", 3), 2);
    }

    /**
     * 1. 采纳尽可能多的0和最前面的1
     * 2. 以尽可能小的增量采纳1（从后往前）
     *
     * @param s
     * @param x
     * @return
     */

    public int getLength(String s, int x) {
        char[] chars = s.toCharArray();
        // 结果标志，-1为默认值，未采纳，0代表采纳的值为0，1代表采纳的值为1
        int[] flag = new int[chars.length];

        // 默认值填充为-1
        Arrays.fill(flag, -1);

        int count = 0;
        // 采纳所有的0
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                flag[i] = 0;
                count++;
            }
            // 控制0的数量，保证初选base不得大于target
            if (Math.pow(2, count + 1) > x) {
                break;
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
                flag[i + 1] = -1;
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
        return ans;
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

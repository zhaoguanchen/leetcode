package leetcode.solution.array;

import java.util.Arrays;

/**
 * 1652. Defuse the Bomb
 * Easy
 */
public class DefuseBomb {

    public static void main(String[] args) {
        int[] nums = {5, 7, 1, 4};
        System.out.println(Arrays.toString(decrypt(nums, 3)));
    }

    public static int[] decrypt(int[] code, int k) {
        int l = code.length;
        // k==0时输入0。  数组默认值为0，直接返回空数组即可
        if (k == 0) {
            return new int[l];
        }
        int[] result = new int[l];
        // 作为sum的字串起点和终点
        int start;
        int end;
        int sum = 0;

        // k小于0时，取前k个值的和。则当i=0时，sum为数组倒数k个值的和
        if (k < 0) {
            k = -k;
            start = l - k;
            end = l - 1;
        } else {
            start = 1;
            end = k;
        }
        // 计算当i=0时，sum数组的值。同时作为缓存，避免重复计算。
        for (int i = start; i <= end; i++) {
            int index = i % l;
            sum += code[index];
        }

        // 随着i增大，sum子数组随着向后移位。
        for (int i = 0; i < l; i++) {
            result[i] = sum;
            // 起点先减掉再后移
            sum -= code[start];
            start = (start + 1) % l;
            // 终点先后移再增加
            end = (end + 1) % l;
            sum += code[end];
        }

        return result;
    }

}

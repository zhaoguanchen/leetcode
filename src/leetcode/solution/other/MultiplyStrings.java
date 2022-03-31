package leetcode.solution.other;

/**
 * 56. Merge Intervals
 */
public class MultiplyStrings {


    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String ans = multiplyStrings.multiply(num1, num2);
        System.out.println(ans);
        // 56088
    }

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] ans = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char p = num1.charAt(i);
                int p1 = p - '0';
                char q = num2.charAt(j);
                int q1 = q - '0';
                // 两数字的积
                int res = p1 * q1;
                // 目标值对应的索引
                int indexOfTen = i + j;
                int indexOfOne = i + j + 1;
                int sum = ans[indexOfOne] + res;
                ans[indexOfOne] = sum % 10;
                ans[indexOfTen] += sum / 10;
            }
        }

        // 排除前段的0
        boolean isFirstZero = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int an : ans) {
            if (0 == an && isFirstZero) {
                continue;
            }
            isFirstZero = false;
            stringBuilder.append(an);
        }

        if (stringBuilder.length() == 0) {
            return "0";
        }

        return stringBuilder.toString();
    }
}

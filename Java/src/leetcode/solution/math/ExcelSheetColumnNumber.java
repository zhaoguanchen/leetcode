package leetcode.solution.math;

/**
 * 171. Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String s = "ZY";
        ExcelSheetColumnNumber number = new ExcelSheetColumnNumber();
        System.out.println(number.titleToNumber(s));
    }

    public int titleToNumber(String s) {
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            result = result * 26;
            result += (s.charAt(i) - 'A' + 1);
        }

        return result;
    }
}

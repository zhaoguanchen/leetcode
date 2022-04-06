package leetcode.solution.array;

import java.util.Arrays;

/**
 * 344. Reverse String
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
        System.out.println(Arrays.toString(s));
//      [o, l, l, e, h]
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}

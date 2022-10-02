package leetcode.solution.string;

/**
 * 58. Length of Last Word
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "Hello World";
        LengthOfLastWord length = new LengthOfLastWord();
        System.out.println(length.lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        int i = s.length() - 1, j;
        while (s.charAt(i) == ' ') {
            i--;
        }
        j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
        }

        return i - j;
    }

}

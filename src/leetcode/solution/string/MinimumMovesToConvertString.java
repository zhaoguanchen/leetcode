package leetcode.solution.string;

/**
 * 2027. Minimum Moves to Convert String
 */
public class MinimumMovesToConvertString {

    public static void main(String[] args) {
        String s = "XXOX";
        MinimumMovesToConvertString convertString = new MinimumMovesToConvertString();
        int ans = convertString.minimumMoves(s);
        System.out.println(ans);
//        Output: 2

    }

    public int minimumMoves(String s) {
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                count++;
                // no need to actually convert
                i += 3;
            } else {
                i++;
            }
        }

        return count;
    }
}

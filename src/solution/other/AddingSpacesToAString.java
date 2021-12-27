package solution.other;

/**
 * 2109. Adding Spaces to a String
 * <p>
 * You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. Each space should be inserted before the character at the given index.
 */
public class AddingSpacesToAString {


    public static void main(String[] args) {
        String s = "LeetcodeHelpsMeLearn";

        int[] spaces = new int[]{8, 13, 15};

        System.out.println(addSpaces(s, spaces));
    }

    public static String addSpaces(String s, int[] spaces) {
        int spaceIndex = 0;
        int maxSpaceIndex = spaces.length;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex >= maxSpaceIndex) {
                sb.append(s.charAt(i));
                continue;
            }

            if (i == spaces[spaceIndex]) {
                sb.append(" ");
                spaceIndex++;
            }

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}

package solution.string;

/**
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "aab";
        String s1 = "aaab";

        System.out.println(isAnagram(s, s1));
    }

    public static boolean isAnagram(String s, String t) {
        char[] cArray = new char[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            cArray[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int index = c - 'a';
            if (cArray[index] <= 0) {
                return false;
            }

            cArray[index]--;
        }

        return true;
    }
}

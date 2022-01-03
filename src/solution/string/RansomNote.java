package solution.string;

/**
 * 383. Ransom Note
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
 * <p>
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public static void main(String[] args) {
        String s = "aab";
        String s1 = "aaab";

        System.out.println(canConstruct(s, s1));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        char[] c = new char[26];

        for (int i = 0; i < magazine.length(); i++) {
            char s = magazine.charAt(i);
            int index = s - 'a';
            c[index]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char s = ransomNote.charAt(i);
            int index = s - 'a';
            if (c[index] <= 0) {
                return false;
            }

            c[index]--;
        }

        return true;
    }
}

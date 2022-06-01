package leetcode.solution.array;

/**
 * 953. Verifying an Alien Dictionary
 */
public class VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        VerifyingAnAlienDictionary verifyingAnAlienDictionary = new VerifyingAnAlienDictionary();
        boolean ans = verifyingAnAlienDictionary.isAlienSorted(words, order);
        System.out.println(ans);
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] orderArray = new int[26];
        // save the location of each letter.
        for (int i = 0; i < order.length(); i++) {
            int index = order.charAt(i) - 'a';
            orderArray[index] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word = words[i];
            String nextWord = words[i + 1];
            for (int j = 0; j < word.length(); j++) {
                // apple -> app, should be false.
                if (j >= nextWord.length()) {
                    return false;
                }
                char current = word.charAt(j);
                char next = nextWord.charAt(j);

                if (current == next) {
                    continue;
                } else {
                    if (orderArray[next - 'a'] < orderArray[current - 'a']) {
                        return false;
                    } else {
                        // if the first different letter is sorted, no need to compare the remaining letters.
                        break;
                    }
                }


            }

        }

        return true;
    }


}

package leetcode.solution.SlideWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 567. Permutation in String
 */
public class PermutationInString {

    public static void main(String[] args) {
//        "trinitrophenylmethylnitramine"
//        "dinitrophenylhydrazinetrinitrophenylmethylnitramine"
        String s = "mine", t = "dinitrophenylhydrazinetrinitrophenylmethylnitramine";
        PermutationInStringWithMap permutationInStringWithMemo = new PermutationInStringWithMap();
        Boolean ans = permutationInStringWithMemo.checkInclusion(s, t);
        System.out.println(ans);
        // false
        PermutationInStringWithArray permutationInStringWithArray = new PermutationInStringWithArray();
        Boolean ans1 = permutationInStringWithArray.checkInclusion(s, t);
        System.out.println(ans1);
        // false
        // not accepted
        PermutationInStringWithHash permutationInStringWithHash = new PermutationInStringWithHash();
        Boolean ans2 = permutationInStringWithHash.checkInclusion(s, t);
        System.out.println(ans2);
        // false

        List<Integer> a = new ArrayList<>();
        for (int i = 2; i < 110; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }

            if (isPrime) {
                a.add(i);
            }
        }
        System.out.println(a.size());
        System.out.println(a);
    }


}

/**
 * Using HashMap and two pointer
 */
class PermutationInStringWithMap {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // 存储s1元素及频率
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            Integer count = tMap.getOrDefault(c, 0);
            tMap.put(c, count + 1);
        }

        int targetLength = s1.length();

        int left = 0;
        int right = 0;

        int count = 0;

        while (right < s2.length()) {
            char char2Add = s2.charAt(right);
            right++;

            // 为目标字符
            if (tMap.containsKey(char2Add)) {
                int newCount = sMap.getOrDefault(char2Add, 0) + 1;

                sMap.put(char2Add, newCount);

                int targetCount = tMap.get(char2Add);

                if (newCount == targetCount) {
                    count++;
                }

            }

            // 字符长度已经匹配
            if (right - left == targetLength) {
                if (count == tMap.size()) {
                    return true;
                }

                char removeChar = s2.charAt(left);
                left++;

                if (tMap.containsKey(removeChar)) {
                    int existCount = sMap.get(removeChar);
                    sMap.put(removeChar, existCount - 1);
                    int targetCount = tMap.get(removeChar);
                    if (existCount == targetCount) {
                        count--;
                    }
                }
            }


        }

        return false;

    }

}


/**
 * Using Array as the Memo
 * <p>
 * will be faster than using Map.
 */
class PermutationInStringWithArray {

    public boolean checkInclusion(String s1, String s2) {
        int[] sourceArray = new int[26];
        int[] targetArray = new int[26];
        // statistics element and frequency of s1
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int index = getIndex(c);
            sourceArray[index]++;
        }

        int targetCount = 0;
        for (int j : sourceArray) {
            if (j > 0) {
                targetCount++;
            }
        }

        int targetLength = s1.length();
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s2.length()) {
            char charRight = s2.charAt(right);
            right++;

            // the right character
            int index = getIndex(charRight);
            targetArray[index]++;

            if (sourceArray[index] == targetArray[index]) {
                count++;
            }

            // same length
            if (right - left == targetLength) {
                if (count == targetCount) {
                    return true;
                }
                char cLeft = s2.charAt(left);
                left++;
                int leftIndex = getIndex(cLeft);
                if (sourceArray[leftIndex] == targetArray[leftIndex]) {
                    count--;
                }
                targetArray[leftIndex]--;
            }


        }

        return false;
    }

    private int getIndex(char c) {
        return c - 'a';

    }
}

/**
 * Using Hash method
 * <p>
 * not accepted while s1 is too long. Because the product will overflow.
 */
class PermutationInStringWithHash {

    private int[] hash;

    public boolean checkInclusion(String s1, String s2) {
        this.hash = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        // 存储s1元素及频率
        int targetProduct = 1;
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            int val = getHashVal(c);
            targetProduct *= val;
        }

        int targetLength = s1.length();

        int left = 0;
        int right = 0;
        int product = 1;
        while (right < s2.length()) {
            char cRight = s2.charAt(right);
            right++;
            int valRight = getHashVal(cRight);
            product *= valRight;
            if (product == targetProduct) {
                return true;
            }
            // 字符长度已经匹配
            if (right - left == targetLength) {
                char cLeft = s2.charAt(left);
                left++;
                int valLeft = getHashVal(cLeft);
                product /= valLeft;
            }

        }

        return false;
    }


    private int getHashVal(char c) {
        int index = c - 'a';
        return hash[index];
    }
}
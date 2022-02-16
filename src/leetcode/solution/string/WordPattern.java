package leetcode.solution.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 290. Word Pattern
 * Given a pattern and a string s, find if s follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */
public class WordPattern {

    public static void main(String[] args) {
//        String a = new String("ab"); // a 为一个引用
//        String b = new String("ab"); // b为另一个引用,对象的内容一样
//        String aa = "ab"; // 放在常量池中
//        String bb = "ab"; // 从常量池中查找
//        System.out.println(aa == bb);// true
//        System.out.println(a == b);// false
//        System.out.println(a.equals(b));// true
//        System.out.println(42 == 42.0);// true

        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }


        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1 == i2);
    }


    public static void printVariable(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }

    public static void printVariable(String arg1, String arg2) {
        System.out.println(arg1 + arg2);
    }


    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        String[] str = s.split(" ");
        if (str.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < str.length; i++) {
            char c = pattern.charAt(i);
            String target = str[i];
            if (map.containsKey(c)) {
                String saved = map.get(c);
                if (!target.equals(saved)) {
                    return false;
                }
            } else {
                if (set.contains(target)) {
                    return false;
                }
                set.add(target);
                map.put(c, target);
            }
        }
        return true;
    }
}
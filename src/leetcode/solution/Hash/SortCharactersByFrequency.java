package leetcode.solution.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 */
public class SortCharactersByFrequency {


    public static void main(String[] args) {
        String s = "wqaqaaasddd";
        SortSolution sortSolution = new SortSolution();
        String ans = sortSolution.frequencySort(s);
        System.out.println(ans);
        // aaaadddqqsw

        BucketSolution bucketSolution = new BucketSolution();
        ans = bucketSolution.frequencySort(s);
        System.out.println(ans);
    }

}

class SortSolution {


    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(count.keySet());

        list.sort((a, b) -> {
            return count.get(b) - count.get(a);
        });

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            int num = count.get(c);
            for (int i = 0; i < num; i++) {
                sb.append(c);
            }
        }

        return sb.toString();

    }
}


class BucketSolution {


    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        for (Integer v : count.values()) {
            max = Math.max(max, v);
        }

        List<List<Character>> buckets = new ArrayList<>();

        for (int i = 0; i < max + 1; i++) {
            buckets.add(new ArrayList<>());
        }

        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = buckets.size() - 1; i >= 0; i--) {
            List<Character> list = buckets.get(i);
            if (!list.isEmpty()) {
                for (Character c : list) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();

    }
}
package leetcode.solution.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams
 */
public class GroupAnagrams {


    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> ans = groupAnagrams.groupAnagrams(s);
        System.out.println(ans);
        // [["bat"],["nat","tan"],["ate","eat","tea"]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            String key = format(s);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }


    private String format(String s) {
        int[] bit = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            bit[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bit.length; i++) {
            sb.append(bit[i]);
        }

        return sb.toString();
    }
}

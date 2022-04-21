package leetcode.solution.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        String s = "25525511135";
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        List<String> ans = restoreIPAddresses.restoreIpAddresses(s);
        System.out.println(ans);

    }


    private List<String> ans;

    private String s;

    public List<String> restoreIpAddresses(String s) {
        this.ans = new ArrayList<>();
        this.s = s;
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(0, 0, path);

        return ans;
    }


    /**
     * @param stage 0,1,2 or 3. represent the number of part that split by '.'
     * @param index current index in the String s
     * @param path  the choices collection
     */
    private void backtrack(int stage, int index, LinkedList<Integer> path) {
        // at stage 3, all characters remain should be considered
        if (stage == 3) {
            String str = s.substring(index);
            if (check(str)) {
                String res = generate(path);
                ans.add(res);
            }
            return;
        }

        // for each part, at least 1 character, at most 3 character
        for (int i = 1; i <= 3; i++) {
            int end = index + i;
            if (end > s.length()) {
                continue;
            }

            // check the substring
            String sub = s.substring(index, end);
            if (!check(sub)) {
                continue;
            }
            // do choice
            path.add(end);
            // backtrack
            backtrack(stage + 1, end, path);
            // revoke the choice
            path.removeLast();
        }


    }


    private boolean check(String str) {
        if (str.length() == 0 || str.length() > 3) {
            return false;
        }

        // if str start with '0', it should not contains more characters.
        if (str.charAt(0) == '0' && str.length() > 1) {
            return false;
        }

        // val should in the range [0,255]
        int val = Integer.parseInt(str);
        return val >= 0 && val <= 255;
    }

    /**
     * generate the result string joined with '.'
     *
     * @param path the index collection that represent the locations of '.'
     * @return
     */
    private String generate(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (path.contains(i)) {
                sb.append(".");
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}
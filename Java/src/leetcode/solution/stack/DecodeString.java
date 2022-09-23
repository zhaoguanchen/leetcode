package leetcode.solution.stack;

import java.util.*;

/**
 * 394. Decode String
 */
public class DecodeString {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        DecodeString decodeString = new DecodeString();

        int[] tokens = {100, 200, 300, 400};
        int power = 200;
        System.out.println(decodeString.getScore(tokens, power));
    }


    public int getScore(int[] tokens, int power) {
        int score = 0;
        int n = tokens.length;

        int right = n - 1;
        for (int i = 0; i <= right; ) {
            int token = tokens[i];
            if (token <= power) {
                score++;
                power -= token;
                i++;
            } else {
                if (score > 0 && tokens[right] > token) {
                    score--;
                    power += tokens[right];
                    right--;
                } else {
                    break;
                }
            }
        }


        return score;
    }

    public int lengthOfLIS(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        int ans = 0;
        for (int num : nums) {

            int max = 1;

            SortedMap<Integer, Integer> sub = map.subMap(num - k, num);

            for (Map.Entry<Integer, Integer> entry : sub.entrySet()) {
                int count = entry.getValue();
                max = Math.max(max, count + 1);
            }


            map.put(num, max);

            ans = Math.max(ans, max);
        }

        return ans;
    }

    public int v(int[][] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
        }

        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int max = 0;
        int i = 0;
        int j = 0;
        int cur = 0;
        while (i < n && j < n) {
            if (starts[i] < ends[j]) {
                cur++;
                i++;
            } else {
                cur--;
                j++;
            }


            max = Math.max(max, cur);
        }

        return max;

    }

    public int partitionString(String s) {
        int ans = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                ans++;
                set.clear();
                continue;
            }

            set.add(c);
            i++;
        }

        if (!set.isEmpty()) {
            ans++;
        }

        return ans;
    }

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int ans = -1;
        int count = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > count) {
                count = e.getValue();
                ans = e.getKey();
            } else if (e.getValue() == count) {
                if (e.getKey() < ans) {
                    ans = e.getKey();
                }
            }
        }

        return ans;
    }

    public int count(int[] numbers, int k) {
        int n = numbers.length;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> memo = new HashMap<>();

        int ans = 0;
        int count = 0;
        while (right < n) {
            int num = numbers[right];
            right++;
            memo.put(num, memo.getOrDefault(num, 0) + 1);
            if (memo.get(num) % 2 == 0) {
                count++;
            }

            while (count == k) {
                ans += n - right + 1;
                int leftNum = numbers[left];
                left++;
                memo.put(leftNum, memo.getOrDefault(leftNum, 0) - 1);
                if (memo.get(leftNum) % 2 != 0) {
                    count--;
                }
            }

        }

        return ans;
    }


    private Map<String, Boolean> memo;

    private int x2;

    private int y2;

    private int c;

    private String ff(int c, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return "No";
        }
        this.memo = new HashMap<>();
        this.c = c;
        this.x2 = x2;
        this.y2 = y2;

        if (dfs(x1, y1)) {
            return "Yes";
        }

        return "No";
    }


    private boolean dfs(int x, int y) {
        if (x == x2 && y == y2) {
            return true;
        }

        if (x > x2 || y > y2) {
            return false;
        }


        String key = x + "," + y;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int sq = (int) Math.sqrt(x + y);
        if (sq * sq == x + y) {
            memo.put(key, false);
            return false;
        }

        boolean ans = dfs(x + y, y) || dfs(x, x + y) || dfs(x + c, y + c);

        memo.put(key, ans);

        return ans;
    }

    public String decodeString(String s) {
        Stack<StringBuilder> charStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder current = new StringBuilder();

        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (Character.isLetter(ch)) {
                current.append(ch);
            } else if ('[' == ch) {
                countStack.push(k);
                k = 0;
                charStack.push(current);
                current = new StringBuilder();
            } else if (']' == ch) {
                StringBuilder encodeStr = current;
                int times = countStack.pop();
                StringBuilder existStr = charStack.pop();
                for (int j = times; j > 0; j--) {
                    existStr.append(encodeStr);
                }
                current = existStr;
            }
        }

        return current.toString();
    }


}

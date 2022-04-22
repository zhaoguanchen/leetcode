package leetcode.solution.BFS;

import java.util.*;

/**
 * 752. Open the Lock
 */
public class OpenTheLock {

    public static void main(String[] args) {
        String[] dead = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        OpenTheLock slidingPuzzle = new OpenTheLock();
        int ans = slidingPuzzle.openLock(dead, target);
        System.out.println(ans);
        // 6
    }

    public int openLock(String[] deadends, String target) {
        String source = "0000";
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        // check whether the source is legal
        if (visited.contains(source)) {
            return -1;
        }
        queue.add(source);
        int step = 0;
        while (!queue.isEmpty()) {
            List<String> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // arrive the target
                if (target.equals(cur)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = getUp(cur, j);
                    // if visited, ignore
                    if (visited.contains(up)) {
                        continue;
                    }

                    temp.add(up);
                    // add to visited memo
                    visited.add(up);
                }

                for (int j = 0; j < 4; j++) {
                    String down = getDown(cur, j);
                    if (visited.contains(down)) {
                        continue;
                    }

                    temp.add(down);
                    visited.add(down);
                }

            }
            // one step
            step++;
            // next cycle, all possible result within one step
            queue.addAll(temp);
        }

        // inaccessible, return -1
        return -1;
    }

    /**
     * get result plus 1
     * @param s
     * @param i
     * @return
     */
    private String getUp(String s, int i) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        if (c == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }

        return new String(chars);
    }

    /**
     * get result minus 1
     * @param s
     * @param i
     * @return
     */
    private String getDown(String s, int i) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        if (c == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }

        return new String(chars);
    }


}

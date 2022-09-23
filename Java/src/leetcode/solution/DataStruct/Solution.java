package leetcode.solution.DataStruct;

import javafx.util.Pair;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 2102. Sequentially Ordinal Rank Tracker
 */
public class Solution {

    public static void main(String[] args) {
        SolutionHelper helper = new SolutionHelper();
//        System.out.println(helper.helper("LDWDL"));
//        System.out.println(helper.helper("DLDD"));
//        System.out.println(helper.helper(""));
//        //，input='1110'， query=[?,+,?,+,+,?]
//
//        System.out.println(helper.countSubStr("1110", Arrays.asList("?", "+", "?", "+", "+", "?")));

//        System.out.println(helper.sum(new int[]{1, 3, 4, 2, 3, 4, 1}));

//        MSolution mSolution = new MSolution();
//
//        int[] a = new int[]{1, 2, 2};
//        int[] b = new int[]{2, 3};
//        List<int[]> ops = new ArrayList<>();
//        ops.add(new int[]{1, 4});
//        ops.add(new int[]{0, 0, 3});
//        ops.add(new int[]{1, 5});
//
//        System.out.println(mSolution.ope(a, b, ops));

        SoSolution solution = new SoSolution();
//          [["a", "c", "a", "b", "b"],
//          ["c", "b", "a", "c", "b"], 
//          ["a", "a", "e", "c", "b"], 
//          ["b", "b", "d", "a", "g"], 
//          ["a", "b", "e", "b", "a"]]
        String[][] matrix = new String[][]{{"a", "c", "a", "b", "b"}, {"c", "b", "a", "c", "b"}, {"a", "a", "e", "c", "b"}, {"b", "b", "d", "a", "g"}, {"a", "b", "e", "b", "a"},}; //1, 5, 3, 7, 2, 8, 9, 6, 4
        String[][] matrix1 = new String[][]{{"b", "b"}, {"c", "a"},}; // 2,3,1
        int[] ans = solution.arrange(matrix);
        System.out.println(Arrays.toString(ans));

    }


}


class SoSolution {
    public int[] arrange(String[][] matrix) {
        int n = matrix[0].length;

        int index = 0;
        List<Pair<String, Integer>> list = new ArrayList<>();
        for (int i = n - 1; i > 0; i--) {
            String s = getStr(i, 0, matrix);
            list.add(new Pair<>(s, index));
            index++;
        }

        for (int i = 0; i < n; i++) {
            String s = getStr(0, i, matrix);
            list.add(new Pair<>(s, index));
            index++;
        }

        list.sort((a, b) -> {
            if (Objects.equals(a.getKey(), b.getKey())) {
                return a.getValue() - b.getValue();
            }
            return a.getKey().compareTo(b.getKey());
        });

        int[] ans = new int[2 * n - 1];
        for (int i = 0; i < list.size(); i++) {
            Pair<String, Integer> pair = list.get(i);
            ans[i] = pair.getValue() + 1;
        }

        return ans;
    }


    private String getStr(int row, int col, String[][] matrix) {
        int n = matrix.length;
        StringBuilder sb = new StringBuilder();

        int i = row;
        int j = col;
        while (sb.length() < n) {
            sb.append(matrix[i][j]);
            i++;
            j++;
            if (i >= n || j >= n) {
                i = row;
                j = col;
            }

        }

        return sb.toString();
    }
}


class Matrix {
    public static void main(String[] args) {

        /**
         * [['1','2','3','4', '16','15','14','13'],
         * ['?','6','7','8', '12','11','10','9' ],
         * ['9','10','11','12' ,'8','7','6','5' ],
         * ['13','14','15','16','4','3','2','?' ]]
         */

//        String[][] strs = new String[][]{{"1", "2", "3", "4", "16", "13", "14", "15"}, {"?", "6", "7", "8", "9", "10", "11", "12"}, {"9", "10", "11", "12", "5", "6", "7", "8"}, {"16", "13", "14", "15", "?", "2", "3", "4"}};
//        System.out.println(Arrays.deepToString(strs));
//
//        MatrixSolution s = new MatrixSolution();
//        System.out.println(Arrays.deepToString(s.arrange(strs)));

        PatrixSolution patrixSolution = new PatrixSolution();
        System.out.println(patrixSolution.move(new int[4][5], 1, 0, 0, 3));
    }
}

class PatrixSolution {
    public int move(int[][] matrix, int startX, int startY, int desX, int desY) {
        int m = matrix.length;
        int n = matrix[0].length;

        Set<String> visited = new HashSet<>();

        int directX = 1;
        int directY = 1;
        int i = startX;
        int j = startY;
        int step = 0;
        while (!(i == desX && j == desY)) {
            String key = i + "," + j + "," + directX + "," + directY;
            if (visited.contains(key)) {
                return -1;
            }

            visited.add(key);

            int nextI = i + directX;
            int nextJ = j + directY;

            if (nextI < 0 || nextI >= m || nextJ < 0 || nextJ >= n) {
                if (nextI < 0 || nextI >= m) {
                    directX = -directX;
                }
                if (nextJ < 0 || nextJ >= n) {
                    directY = -directY;
                }
            } else {
                i = nextI;
                j = nextJ;
            }

            step++;
        }

        return step;
    }


}

class MatrixSolution {
    public String[][] arrange(String[][] matrix) {
        int k = matrix[0].length / 4;
        int m = matrix.length;
        int n = matrix[0].length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int missVal = findMiss(matrix, i * 4);
            list.add(new int[]{i, missVal});
        }

        list.sort((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        return generate(m, n, matrix, list);
    }

    private String[][] generate(int m, int n, String[][] source, List<int[]> list) {
        String[][] ans = new String[m][n];
        int k = n / 4;

        for (int i = 0; i < k; i++) {
            int sourceIndex = list.get(i)[0];
            int sourceBase = sourceIndex * 4;
            int targetBase = i * 4;
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    ans[row][targetBase + col] = source[row][sourceBase + col];
                }
            }

        }

        return ans;
    }

    private int findMiss(String[][] matrix, int baseCol) {
        int[] ans = new int[3];
        int[] count = new int[17];

        for (int i = 0; i < 4; i++) {
            for (int j = baseCol; j < baseCol + 4; j++) {
                if ("?".equals(matrix[i][j])) {
                    ans[0] = i;
                    ans[1] = j;
                } else {
                    int num = Integer.parseInt(matrix[i][j]);
                    count[num]++;

                }
            }
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                ans[2] = i;
                break;
            }
        }

        matrix[ans[0]][ans[1]] = String.valueOf(ans[2]);
        return ans[2];
    }
}

class MSolution {
    public List<Integer> ope(int[] a, int[] b, List<int[]> query) {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();

        for (int num : a) {
            mapA.put(num, mapA.getOrDefault(num, 0) + 1);
        }
        for (int num : b) {
            mapB.put(num, mapB.getOrDefault(num, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for (int[] op : query) {
            if (op[0] == 0) {
                int index = op[1];
                int old = a[index];
                int newOne = op[2];
                mapA.put(old, mapA.get(old) - 1);
                if (mapA.get(old) == 0) {
                    mapA.remove(old);
                }
                a[index] = newOne;
                mapA.put(newOne, mapA.getOrDefault(newOne, 0) + 1);
            } else {
                int sum = op[1];

                int res = 0;
                for (int num : mapB.keySet()) {
                    int target = sum - num;
                    if (mapA.containsKey(target)) {
                        res += mapA.get(target) * mapB.get(num);
                    }
                }

                ans.add(res);

            }


        }
        return ans;

    }
}

class WSolution {
    public int[][] beautyOfMatrix(int[][] matrix, int k) {
        Map<Integer, int[]> cells = new HashMap<>();
//store grids into arrays keyed by their grid id
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int r = k * (i / k);
                int c = k * (j / k);
                int key = r * n + c;
                cells.put(key, new int[]{r, c});
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(matrix[i][j]);
            }
        }
//calculate beauty of each grid
        TreeMap<Integer, List<Integer>> beauty = new TreeMap<>();
        for (Integer kS : map.keySet()) {
            int b = getPositive(map.get(kS));
            if (!beauty.containsKey(b)) beauty.put(b, new ArrayList<>());
            beauty.get(b).add(kS);
        }
//sorting beauty to access them in order
        for (List kS : map.values()) {
            Collections.sort(kS);
        }

        int[][] res = new int[n][n]; //resultant array to return
        int r1 = 0;
        int c1 = 0;
        for (List<Integer> l : beauty.values()) {
            for (int idx : l) {
                int row = cells.get(idx)[0];
                int col = cells.get(idx)[1];
                for (int i = row, rk = 0; i < row + k; i++, rk++) {
                    for (int j = col, ck = 0; j < col + k; j++, ck++) {
                        res[k * (r1 / k) + rk][k * (c1 / k) + ck] = matrix[i][j];
                    }
                }
                if (c1 + k < n) {
                    c1 += k;
                } else {
                    r1 += k;
                    c1 = 0;
                }
            }
        }
        return res;
    }

    /* function to get first positive */
    private int getPositive(List<Integer> list) {
        int num = 1;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : list) {
            pq.offer(i);
        }

        return num;
    }

}


/**
 * moving diagonally。一个 n*m的矩阵，start from(x1，y1)一开始以step(dx=1，dy=1)移 动，如果x方向移动出了矩阵，step变成(dx=-dx，dy=dy)并且回到移动出矩阵前的位置 以新的step方向继续移动。如果y方向移动出了矩阵，step变成(dx=dx，dy=-dy)并且 回到移动出矩阵前的位置以新的step方向继续移动。如果x，y方向同时移动出了矩阵 ，step变成(dx=-dx，dy=-dy)并且回到移动出矩阵前的位置以新的step方向继续移动。 要求输出以这种移动方式需要多少step可以移动到(x2，y2)，如果无法到达(x2，y2)， 输出-1 (感觉是其实最短路径的变种，是不是这样?)用一个4维数组记录是否已经
 * visit 某个位置以及移动
 */
class ASolution {
    /**
     * @param grid:        a chessboard included 0 (false) and 1 (true) * @param source: a point
     * @param destination: a point * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) { // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if (source.x == destination.x && source.y == destination.y) return 0;
        int col = grid.length;
        int row = grid[0].length;
        int res = 0;
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[col][row];
        queue.offer(source);
        visited[source.x][source.y] = true;
        int[] dx = {1, 1, -1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 1, -1, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int level = 0; level < size; level++) {
                Point current = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (isValid(nx, ny, grid) && !visited[nx][ny]) {
                        if (nx == destination.x && ny == destination.y) return res;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && !grid[x][y];

    }
}

class xSolution {
    public static void main(String[] args) {
        String text = "ababababac";
        List<String> array = new ArrayList<>();
        array.add("ab");
        array.add("abab");
        array.add("abc");
        List<Integer> res = helper(text, array);
        System.out.println(res);
    }

    private static List<Integer> helper(String text, List<String> list) {
        List<Integer> res = new ArrayList<>();
        if (text == null || text.length() == 0 || list == null || list.size() == 0) return res;
        for (String s : list) {
            int count = countMatches(text, s);
            res.add(count);
        }
        return res;
    }

    private static int countMatches(String text, String s) {
        if (s == null || s.length() == 0) return 0;
        System.out.println(Arrays.toString(text.split(s, -1)));
        return text.split(s, -1).length - 1;
    }
}

class SSolution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("car");
        list.add("class"); // list.add("");
// list.add("aa");
        List<String> res = helper(list);
        System.out.println(res);
        //output:{"ap","pc","cc","ca"}
    }

    private static List<String> helper(List<String> list) {
        List<String> res = new ArrayList<>();
        if (list == null || list.size() == 0) return res;
        if (list.size() == 1) {
            char[] array = list.get(0).toCharArray();
            res.add(String.valueOf(array[0]));
            return res;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            if (list.get(i) == null || list.get(i).length() == 0) {
                sb.append("");
            } else {
                char[] first = list.get(i).toCharArray();
                sb.append(first[0]);
            }
            if (list.get(i + 1) == null || list.get(i + 1).length() == 0) {
                sb.append("");
            } else {
                char[] second = list.get(i + 1).toCharArray();
                sb.append(second[0]);
            }
            res.add(sb.toString());
        }

        StringBuilder sb = new StringBuilder();
        if (list.get(list.size() - 1) == null || list.get(list.size() - 1).length() == 0) {
            sb.append("");
        } else {
            char[] second = list.get(list.size() - 1).toCharArray();
            sb.append(second[0]);
        }
        if (list.get(0) == null || list.get(0).length() == 0) {
            sb.append("");
        } else {
            char[] first = list.get(0).toCharArray();
            sb.append(first[0]);
        }
        res.add(sb.toString());
        return res;
    }
}


class AlmostTetris {
    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int[] figures = {4, 2, 1, 3};
        AlmostTetris almostTetris = new AlmostTetris();
        System.out.println(Arrays.deepToString(almostTetris.almostTetris(n, m, figures)));
    }

    int[][][] figureDimension = {{{0, 0}}, {{0, 0}, {0, 1}, {0, 2}}, {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, {{0, 1}, {1, 0}, {1, 1}, {1, 2}}};

    public int[][] almostTetris(int n, int m, int[] figures) {
        int[][] matrix = new int[n][m];
        int code = 1;
        for (int figure : figures) {
            boolean figurePlaced = false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (isPossibleAtThisPoint(matrix, figureDimension[figure - 1], i, j, code)) {
                        figurePlaced = true;
                        code++;
                        break;
                    }
                }

                if (figurePlaced) {
                    break;
                }
            }

        }
        return matrix;
    }

    private boolean isPossibleAtThisPoint(int[][] matrix, int[][] fd, int x, int y, int code) {
        for (int i = 0; i < fd.length; i++) {
            int next_x = fd[i][0] + x;
            int next_y = fd[i][1] + y;
            if (next_x >= 0 && next_x < matrix.length && next_y >= 0 && next_y < matrix[0].length) {
                if (matrix[next_x][next_y] != 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        for (int i = 0; i < fd.length; i++) {
            int next_x = fd[i][0] + x;
            int next_y = fd[i][1] + y;
            matrix[next_x][next_y] = code;
        }
        return true;
    }
}

class SolutionHelper {
    // 1, 3, 4, 2, 3, 4, 1
    // 0, 1, 4, 8, 10, 13, 17, 18
    public int sum(int[] nums) {
        int[] sum = new int[nums.length + 1];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i + 1] = nums[i] + sum[i];
        }
        int count = 0;
        for (int i = 4; i < sum.length; i++) {
            if (sum[i] - sum[i - 3] > sum[i - 1] - sum[i - 4]) {
                count++;
            }
        }

        return count;
    }


    public String helper(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('W', 0);
        map.put('D', 0);
        map.put('L', 0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.get(c) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int total = s.length();
        while (total > 0) {
            if (map.get('W') > 0) {
                sb.append("W");
                total--;
                map.put('W', map.get('W') - 1);
            }

            if (map.get('D') > 0) {
                sb.append("D");
                total--;
                map.put('D', map.get('D') - 1);
            }

            if (map.get('L') > 0) {
                sb.append("L");
                total--;
                map.put('L', map.get('L') - 1);
            }

        }

        return sb.toString();

    }


//    给一个字符串形式的二进制数，给一个query list，query有两种，'+'是把那个二进制数加一，'?'
//            1. 2.
//    是在返回list中加入二进制字符串中'1'的个数 比如说，input='1110'， query=[?,+,?,+,+,?]
//            return [3， 4， 2]


    public List<Integer> countSubStr(String str, List<String> ops) {
        int num = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                num += Math.pow(2, str.length() - 1 - i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String o : ops) {
            if ("?".equals(o)) {
                ans.add(countOne(num));
            } else {
                num++;

            }
        }

        return ans;
    }

    private int countOne(int n) {
        int ans = 0;
        while (n > 0) {
            ans++;
            n = n & (n - 1);
        }

        return ans;
    }

    /**
     * Substring divisible
     * 问把num转换为string后 长度为k的substring中有多少个可以拿来整除num
     * 这道题就有2,6,4都可以
     *
     * @param n
     * @param k
     * @return
     */
    public int countSubStr(int n, int k) {
        String str = String.valueOf(n);
        int count = 0;
        long strNum = Long.parseLong(str);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                if (sub.length() == k) {
                    long num = Long.parseLong(sub);
                    if (num != 0 && strNum % num == 0 && !set.contains(sub)) {
                        count++;
                        set.add(sub);

                    }
                }
            }
        }
        return count;
    }


    public int shortestPath(boolean[][] grid, Point source, Point destination) { // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return -1;
        if (source.x == destination.x && source.y == destination.y) return 0;
        int col = grid.length;
        int row = grid[0].length;
        int res = 0;
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[col][row];
        queue.offer(source);
        visited[source.x][source.y] = true;
        int[] dx = {1, 1, -1, -1, 1, 1, -1, -1};
        int[] dy = {1, -1, 1, -1, 1, -1, 1, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int level = 0; level < size; level++) {
                Point current = queue.poll();
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];
                    if (isValid(nx, ny, grid) && !visited[nx][ny]) {
                        if (nx == destination.x && ny == destination.y) return res;
                        visited[nx][ny] = true;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, boolean[][] grid) {
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length && !grid[x][y];
    }
}


class CountOccurrences {

    public int helper(int n) {
        int result = 0;

        while (n > 0) {
            int reminder = n % 10;
            if (reminder == 0 || reminder == 2 || reminder == 4) {
                result++;
            }
            n = n / 10;
        }
        return result;
    }

    public int number(int n) {
        int count = 1;
        for (int i = 1; i <= n; i++) {
            count += helper(i);
        }
        return count;
    }

    public static void main(String[] args) {
        CountOccurrences oc = new CountOccurrences();
        int total = oc.number(22);
        System.out.println(total);

    }

}

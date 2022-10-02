package leetcode.solution.string;

/**
 * kmp算法实现
 */
public class KMP {

    public static void main(String[] args) {
        String s = "mississippi";
        String s1 = "issip";
        KMP kmp = new KMP();
        int ans = kmp.kmpSearch(s, s1);
        System.out.println(ans);
    }


    public int kmpSearch(String s, String p) {
        // 构建next数组
        int[] lsp = generateNext(p);

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            // 当前字符匹配
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            // j到达末尾，全字符串匹配
            if (j == p.length()) {
                // 找到答案，直接返回
                return i - j;
            }

            if (i < s.length() && s.charAt(i) != p.charAt(j)) {
                // 跳到已匹配的位置
                if (j != 0) {
                    j = lsp[j - 1];
                } else {
                    // 未匹配，i后移
                    i++;
                }
            }
        }

        // 未找到结果，返回-1
        return -1;
    }

    /**
     * 构建next数组
     *
     * @param p
     * @return
     */
    private int[] generateNext(String p) {
        int n = p.length();
        // 错位匹配，寻找最长前缀
        int length = 0;
        int i = 1;
        int[] ans = new int[n];

        while (i < p.length()) {
            // 前缀与后缀相同，长度加一并赋值到当前位置
            if (p.charAt(length) == p.charAt(i)) {
                length++;
                ans[i] = length;
                i++;
            } else {
                // 不匹配，回退到已匹配的位置，这个与search算法一致
                if (length != 0) {
                    length = ans[length - 1];
                } else {
                    // 不匹配，赋值为0
                    ans[i] = 0;
                    i++;
                }
            }
        }

        return ans;
    }


}

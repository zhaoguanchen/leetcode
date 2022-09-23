package leetcode.solution.other;

/**
 * 165. Compare Version Numbers
 */
public class CompareVersionNumbers {


    public static void main(String[] args) {
        String version1 = "0.1", version2 = "1.1";
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        int ans = compareVersionNumbers.compareVersion(version1, version2);
        System.out.println(ans);
        // -1
    }

    public int compareVersion(String version1, String version2) {

        String[] strings1 = version1.split("\\.");
        String[] strings2 = version2.split("\\.");

        int n = Math.max(strings1.length, strings2.length);

        for (int i = 0; i < n; i++) {
            int p1 = i < strings1.length ? Integer.parseInt(strings1[i]) : 0;
            int p2 = i < strings2.length ? Integer.parseInt(strings2[i]) : 0;

            if (p1 < p2) {
                return -1;
            }
            if (p1 > p2) {
                return 1;
            }

        }

        return 0;

    }
}

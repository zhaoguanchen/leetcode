package leetcode.solution.array;

/**
 * 2239. Find Closest Number to Zero
 */
public class FindClosestNumberToZero {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        FindClosestNumberToZero findClosestNumberToZero = new FindClosestNumberToZero();
        int ans = findClosestNumberToZero.findClosestNumber(arr);
        System.out.println(ans);
    }


    public int findClosestNumber(int[] nums) {
        int ans = Integer.MAX_VALUE;

        for (int num : nums) {
            if (Math.abs(num) < Math.abs(ans)) {
                ans = num;
            } else if (Math.abs(num) == Math.abs(ans)) {
                if (num > ans) {
                    ans = num;
                }
            }
        }

        return ans;
    }
}

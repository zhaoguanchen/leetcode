package leetcode.solution.array;

/**
 * 768. Max Chunks To Make Sorted II
 */
public class MaxChunksToMakeSortedII {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4, 4};
        MaxChunksToMakeSortedII max = new MaxChunksToMakeSortedII();
        int ans = max.maxChunksToSorted(nums);
        System.out.println(ans);
        // 4    [2,1],[3],[4],[4]
    }

    /**
     * Iterate through the array,
     * each time all elements to the left are smaller (or equal) to all elements to the right,
     * there is a new chunk.
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] leftMaxMemo = new int[n];
        int[] rightMaxMemo = new int[n];

        int leftMax = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            leftMaxMemo[i] = leftMax;
        }

        int rightMax = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            rightMaxMemo[i] = rightMax;
            rightMax = Math.min(rightMax, arr[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (rightMaxMemo[i] >= leftMaxMemo[i]) {
                count++;
            }
        }

        return count;
    }

}

package leetcode.solution.array;

/**
 * 769. Max Chunks To Make Sorted
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 3, 4};
        MaxChunksToMakeSorted max = new MaxChunksToMakeSorted();
        int ans = max.maxChunksToSorted(nums);
        System.out.println(ans);
        // 4      [1,0],[2],[3],[4]
    }

    /**
     * Iterate through the array,
     * each time the maximum value of all elements to the left equals to the index,
     * there is a new chunk.
     *
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            // it should be the chunk if the max value to left equals the index value.
            if (max == i) {
                ans++;
            }
        }

        return ans;
    }

}

package leetcode.solution.array.twopointer;

/**
 * 42. Trapping Rain Water
 */
public class ContainerWithMostWater {


    public static void main(String[] args) {
        int[] h = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater calculator = new ContainerWithMostWater();
        int ans = calculator.maxArea(h);
        System.out.println(ans);
        // 49
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int ans = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, currentArea);

            // 移动较小的指针才可能得到更大的面积
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }


}

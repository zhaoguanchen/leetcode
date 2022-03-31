package leetcode.solution.other;

/**
 * 42. Trapping Rain Water
 */
public class TrappingRainWater {


    public static void main(String[] args) {
        int[] h = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater calculator = new TrappingRainWater();
        int ans = calculator.trap(h);
        System.out.println(ans);
        int ans2 = calculator.trap2(h);
        System.out.println(ans2);
        // 6
    }

    /**
     * 备忘录
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int n = height.length;
        // 左边最大的值
        int[] leftMax = new int[n];
        // 右边最大的值
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    /**
     * 双指针
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[0];
        int rightMax = height[n - 1];

        int ans = 0;
        while (left < right) {
            // 如果为自己，那就不存水
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;

    }
}

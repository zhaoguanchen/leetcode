package leetcode.solution.array;

/**
 * 287. Find the Duplicate Number
 */
public class FindTheDuplicateNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 5};
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicate(nums));
    }

    /**
     * 参考了环检测的算法，同时还可以利用hashset，排序等方法
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        // 为什么是do-while, 因为刚开始fast==slow
        do {
            // 快指针走两步，慢指针走一步
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        // 指针相遇，将快指针回退到起点
        fast = nums[0];

        // 相同速度前进，再次相遇的点为环的起点
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

}

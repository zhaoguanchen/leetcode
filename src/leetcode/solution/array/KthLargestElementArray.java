package leetcode.solution.array;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 */
public class KthLargestElementArray {

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        KthLargestElementArray test = new KthLargestElementArray();
        int ans = test.findKthLargest(nums, k);
        System.out.println(ans);

        int ans2 = test.findKthLargestHeap(nums, k);
        System.out.println(ans2);
    }

    private int[] array;

    private int target;

    public int findKthLargest(int[] nums, int k) {
        target = nums.length - k;
        array = nums;
        // 打乱原数组，避免极端情况
        // 在Leetode提交中执行时间有显著提高
        shuffle(array);

        return helper(0, nums.length - 1);
    }


    private int helper(int left, int right) {
        int ans;
        if (left >= right) {
            return array[left];
        }

        int pivot = getPartition(left, right);
        if (pivot < target) {
            ans = helper(pivot + 1, right);
        } else if (pivot > target) {
            ans = helper(left, pivot - 1);
        } else {
            ans = array[pivot];
        }
        return ans;


    }

    private int getPartition(int left, int right) {
        int baseVal = array[right];
        int index = left;

        for (int i = left; i < right; i++) {
            if (array[i] < baseVal) {
                swap(i, index);
                index++;
            }
        }

        swap(index, right);

        return index;

    }

    private void swap(int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public int findKthLargestHeap(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : nums) {
            priorityQueue.add(i);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        return priorityQueue.peek();
    }


    /**
     * 洗牌
     *
     * @param nums
     */
    private void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(i, r);
        }
    }
}

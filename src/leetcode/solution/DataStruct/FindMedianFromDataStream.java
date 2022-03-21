package leetcode.solution.DataStruct;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 */
public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        double a = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        System.out.println(a);
        medianFinder.addNum(3);    // arr[1, 2, 3]
        double b = medianFinder.findMedian(); // return 2.0
        System.out.println(b);
    }

}

class MedianFinder {

    /**
     * 大顶堆：存储较小的元素
     */
    private PriorityQueue<Integer> small;

    /**
     * 小顶堆：存储较大的元素
     */
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>();
        // 自然顺序倒序排列
        large = new PriorityQueue<>(Comparator.reverseOrder());
    }

    /**
     * 添加元素
     *
     * @param num
     */
    public void addNum(int num) {
        // 先添加到较多的堆，找出最值后pop出来，然后添加到元素较少的堆。
        // 这样才能保证small中的元素都比large中的小
        if (small.size() > large.size()) {
            small.add(num);
            large.add(small.poll());
        } else {
            large.add(num);
            small.add(large.poll());
        }

    }

    /**
     * 找中位数
     *
     * @return
     */
    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.size() > large.size() ? small.peek() : large.peek();
        }
    }

    /**
     * 打印 测试用
     */
    public void print() {
        System.out.println(small);
        System.out.println(large);
    }
}

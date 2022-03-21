package leetcode.solution.DataStruct;

import java.util.Arrays;

/**
 * imply heap
 * 数组实现大顶堆与小顶堆
 * <p>
 * there are no associated Leetcode problem
 */
public class HeapImplement {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(5);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(10);
        minHeap.add(33);
        minHeap.add(12);
        minHeap.add(22);
        minHeap.add(11);
        minHeap.add(6);
        minHeap.add(12);
        minHeap.add(22);
        minHeap.add(11);
        minHeap.add(6);
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();

        System.out.println("++++++++++++++++++++++++++++");
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.add(5);
        maxHeap.add(1);
        maxHeap.add(2);
        maxHeap.add(10);
        maxHeap.add(33);
        maxHeap.add(12);
        maxHeap.add(22);
        maxHeap.add(11);
        maxHeap.add(6);

        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();
        System.out.println(minHeap.pop());
        minHeap.print();

    }

}

/**
 * 小顶堆
 */
class MinHeap {

    /**
     * 使用数组存储元素   array[0]为堆顶元素
     */
    private int[] array;

    /**
     * 堆中元素数量
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity
     */
    MinHeap(int capacity) {
        array = new int[capacity];
    }

    /**
     * 父节点
     *
     * @param i
     * @return
     */
    private int getParent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 左子节点
     *
     * @param i
     * @return
     */
    private int getLeftChild(int i) {
        return 1 + 2 * i;
    }

    /**
     * 右子节点
     *
     * @param i
     * @return
     */
    private int getRightChild(int i) {
        return 1 + 2 * i + 1;
    }


    /**
     * 弹出堆顶元素
     *
     * @return
     */
    public int pop() {
        if (size == 0) {
            return 0;
        }
        int ans = array[0];
        // 交换堆顶与末尾元素
        swap(0, size - 1);
        // 删除末尾元素
        array[size - 1] = 0;
        size--;

        // 下沉堆顶元素
        sink(0);
        return ans;
    }

    /**
     * 获取堆顶元素
     *
     * @return
     */
    public int peek() {
        return array[0];
    }

    /**
     * 添加元素
     *
     * @param x
     */
    public void add(int x) {
        if (size >= array.length) {
            return;
        }

        // 添加元素
        array[size] = x;
        // 上浮该元素
        swim(size);
        size++;
    }

    /**
     * 上浮元素
     *
     * @param index 目标元素的索引
     */
    private void swim(int index) {
        while (array[index] < array[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }


    /**
     * 下沉元素
     *
     * @param index 目标元素的索引
     */
    private void sink(int index) {
        while (getLeftChild(index) < size) {
            int target = getLeftChild(index);
            // 找到左右子节点中较小的
            if (getRightChild(index) < size && array[getRightChild(index)] < array[target]) {
                target = getRightChild(index);
            }

            // 当前节点比左右子节点较小的还小，则不用处理
            if (array[index] < array[target]) {
                return;
            }
            // 交换当前节点与较小子节点
            swap(target, index);
            // while循环继续下沉
            index = target;
        }


    }

    /**
     * 交换元素
     *
     * @param source 索引
     * @param target 索引
     */
    private void swap(int source, int target) {
        int temp = array[source];
        array[source] = array[target];
        array[target] = temp;
    }


    /**
     * 打印 测试用
     */
    public void print() {
        System.out.println(Arrays.toString(array));
    }
}


/**
 * 大顶堆
 */
class MaxHeap {

    /**
     * 使用数组存储元素   array[0]为堆顶元素
     */
    private int[] array;

    /**
     * 堆中元素数量
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity
     */
    MaxHeap(int capacity) {
        array = new int[capacity];
    }

    /**
     * 父节点
     *
     * @param i
     * @return
     */
    private int getParent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 左子节点
     *
     * @param i
     * @return
     */
    private int getLeftChild(int i) {
        return 1 + 2 * i;
    }

    /**
     * 右子节点
     *
     * @param i
     * @return
     */
    private int getRightChild(int i) {
        return 1 + 2 * i + 1;
    }


    /**
     * 弹出堆顶元素
     *
     * @return
     */
    public int pop() {
        int ans = array[0];
        // 交换堆顶与末尾元素
        swap(0, size - 1);
        // 删除末尾元素
        array[size - 1] = 0;
        size--;

        // 下沉堆顶元素
        sink(0);
        return ans;
    }

    /**
     * 获取堆顶元素
     *
     * @return
     */
    public int peek() {
        return array[0];
    }

    /**
     * 添加元素
     *
     * @param x
     */
    public void add(int x) {
        if (size >= array.length) {
            return;
        }

        // 添加元素
        array[size] = x;
        // 上浮该元素
        swim(size);
        size++;
    }

    /**
     * 上浮元素
     *
     * @param index 目标元素的索引
     */
    private void swim(int index) {
        while (array[index] > array[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }


    /**
     * 下沉元素
     *
     * @param index 目标元素的索引
     */
    private void sink(int index) {
        while (getLeftChild(index) < size) {
            int target = getLeftChild(index);
            // 找到左右子节点中较大的
            if (getRightChild(index) < size && array[getRightChild(index)] > array[target]) {
                target = getRightChild(index);
            }

            // 当前节点比左右子节点较大的还大，则不用处理
            if (array[index] > array[target]) {
                return;
            }
            // 交换当前节点与较大子节点，使较大的节点上浮
            swap(target, index);
            // while循环继续下沉当前节点
            index = target;
        }


    }

    /**
     * 交换元素
     *
     * @param source 索引
     * @param target 索引
     */
    private void swap(int source, int target) {
        int temp = array[source];
        array[source] = array[target];
        array[target] = temp;
    }


    /**
     * 打印 测试用
     */
    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
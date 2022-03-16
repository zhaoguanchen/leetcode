package sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr1 = new int[]{128, 294, 133, 295, 175, 8, 232, 248, 241, 164, 11, 60, 238, 133, 291, 116, 6, 67, 98, 67, 196, 260, 181, 160, 83, 160, 90, 153, 233, 216};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr1, 0, arr1.length - 1);
        System.out.println(Arrays.toString(arr1));
    }


    /**
     * 传统方法
     * 选择left为基准点
     *
     * @param array
     * @param left
     * @param right
     */
    public void quickSortLeftBase(int[] array, int left, int right) {
        // 元素个数小于等于1，无需排序，结束
        if (left >= right) {
            return;
        }

        int index = getPartition(array, left, right);
        quickSortLeftBase(array, left, index - 1);
        quickSortLeftBase(array, index + 1, right);
    }


    /**
     * 传统方法
     * 选择left为基准点，设为base
     * 先从右边元素开始，找到第一个比base小的，将array[i]设为该值(array[j])。
     * 再从左边开始，找到第一个比base大的，将array[j]设为该值(array[i])。
     * 结束循环后，将array[i]的值设为base。
     *
     * @param array
     * @param left
     * @param right
     */
    private int getPartition(int[] array, int left, int right) {
        int i = left, j = right;
        int baseVal = array[left];

        while (i < j) {
            while (i < j && array[j] >= baseVal) {
                j--;
            }
            array[i] = array[j];
            while (i < j && array[i] <= baseVal) {
                i++;
            }
            array[j] = array[i];
        }

        array[i] = baseVal;
        // i 为基准点坐标
        return i;
    }

    /**
     * 快速排序调用层
     * 找到分隔点pivot，使左侧小于base，右侧大于base。
     * 递归处理左右子数组。
     *
     * @param array
     * @param left
     * @param right
     */
    public void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // find pivot element such that
        // elements smaller than pivot are on the left
        // elements greater than pivot are on the right
        int pivot = partition(array, left, right);
        // recursive call on the left of pivot
        quickSort(array, left, pivot - 1);
        // recursive call on the right of pivot
        quickSort(array, pivot + 1, right);

    }

    /**
     * 分隔数组，返回分界点
     * 选择right为基准点，设为base
     * 从左往右进行for循环，遇到比base小的，则与index进行交换。
     * index后移。
     * 结束循环后，array[index]为第一个不小于base的元素，与array进行交换，则index左侧均小于base，右侧均大于base。
     *
     * @param array
     * @param left
     * @param right
     */
    public int partition(int[] array, int left, int right) {
        // choose the rightmost element as pivot
        int pivot = array[right];
        // pointer for greater element
        int index = left;
        // traverse through all elements
        // compare each element with pivot
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                // if element smaller than pivot is found
                // swap it with the greater element pointed by i
                // swapping element at i with element at j
                swap(array, index, j);
                index++;
            }
        }

        // swap the pivot element with the greater element specified by i
        swap(array, index, right);
        // return the position from where partition is done
        return (index);
    }

    /**
     * 交换节点
     *
     * @param array
     * @param left
     * @param right
     */
    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


}

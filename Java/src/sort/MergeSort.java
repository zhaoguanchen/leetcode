package sort;

import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 8, 9};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将数组转为全局变量，避免传参
     */
    private int[] arr;

    /**
     * 临时数组
     */
    private int[] temp;

    private void sort(int[] array) {
        arr = array;
        temp = new int[arr.length];
        mergeSort(0, array.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }

        // 切记：采用移位运算符的话，要用括号括住
        int mid = left + ((right - left) >> 1);

        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    /**
     * 合并
     *
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int left, int mid, int right) {
        // 左半边和右半边指针
        int p = left;
        int q = mid + 1;
        // 将数组缓存到临时数组
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        for (int cur = left; cur <= right; cur++) {
            if (p > mid) {
                arr[cur] = temp[q];
                q++;
            } else if (q > right) {
                arr[cur] = temp[p];
                p++;
            } else if (temp[p] > temp[q]) {
                arr[cur] = temp[q];
                q++;
            } else {
                arr[cur] = temp[p];
                p++;
            }

        }

    }


}

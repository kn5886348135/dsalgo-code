package com.example.dsalgo.sort;

/**
 * @Description: 桶排序算法
 * @Author: paladin
 * @date: 2020/10/1 22:20
 */
public class BucketSort {

    /**
     * @param arr
     * @param bucketSize
     */
    public static void bucketSort(int[] arr,int bucketSize) {
        int len = arr.length;

        if (len <= 1) {
            return;
        }
        int min = arr[0];
        int max = arr[1];
        for (int i = 0; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int bucketCount = (max - min) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];

        for (int i = 0; i < len; i++) {
            int bucketIndex = (arr[i] - min) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length) {
                ensurecapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0) {
                continue;
            }
            quickSortC(buckets[i], 0, indexArr[i] - i);
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }

    private static void ensurecapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int i = 0; i < tempArr.length; i++) {
            newArr[i] = tempArr[i];
        }
        buckets[bucketIndex] = newArr;
    }

    private static void quickSortC(int[] arr,int p,int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);
        quickSortC(arr, p, q - 1);
        quickSortC(arr, q + 1, r);
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

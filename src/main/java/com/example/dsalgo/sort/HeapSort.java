package com.example.dsalgo.sort;

/**
 * @Description: 堆排序
 * @Author: paladin
 * @date: 2020/10/5 21:44
 */
public class  HeapSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }
        int k = len - 1;
        while (k > 0) {
            swap(arr, 0, k);
            heapify(arr, --k, 0);
        }
    }

    // 建堆
    private static void buildHeap(int[] arr) {
        int len = arr.length;
        for (int i = (len - 1) >> 1; i >= 0; i--) {
            heapify(arr, len - 1, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
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

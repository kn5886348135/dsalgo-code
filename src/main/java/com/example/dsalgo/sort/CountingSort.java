package com.example.dsalgo.sort;

/**
 * @Description: 计数排序
 * @Author: paladin
 * @date: 2020/10/1 19:25
 */
public class CountingSort {

    public static void countingSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }

        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int[] c = new int[max + 1];
        for (int i = 0; i < len; i++) {
            c[arr[i]]++;
        }
        for (int i = 0; i < max + 1; i++) {
            c[i] = c[i - 1] + c[i];
        }

        int[] r = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            int index = c[arr[i]] - 1;
            r[index] = arr[i];
            c[arr[i]]--;
        }

        for (int i = 0; i < len; i++) {
            arr[i] = r[i];
        }
    }
}

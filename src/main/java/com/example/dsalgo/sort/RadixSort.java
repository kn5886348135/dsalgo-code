package com.example.dsalgo.sort;

/**
 * @Description: 基数排序
 * @Author: paladin
 * @date: 2020/10/3 13:11
 */
public class RadixSort {

    public static void radixSort(int[] arr){
        int len = arr.length;
        int max = arr[0];
        for (int i = 0; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] arr, int exp) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }

        int[] c = new int[10];
        for (int i = 0; i < len; i++) {
            c[(arr[i] / exp) % 10]++;
        }
        for (int i = 0; i < c.length; i++) {
            c[i] += c[i - 1];
        }

        int[] r = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            r[c[(arr[i] / exp) % 10] - 1] = arr[i];
            c[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < len; i++) {
            arr[i] = r[i];
        }
    }
}

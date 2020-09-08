package com.example.dsalgo.sort;

/**
 * @Description: 寻找第K小的数据
 * @Author: paladin
 * @date: 2020/9/8 21:16
 */
public class KthSmalllest {
    public static void main(String[] args) {

    }

    public static int kthSmalllest(int[] arr, int k) {
        int len = arr.length;
        if (arr == null || len < k) {
            return -1;
        }
        int partition = partition(arr, 0, len - 1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition + 1, len - 1);
            }else {
                partition = partition(arr, 0, partition - 1);
            }
        }
        return arr[partition];
    }
    
    private static int partition(int[] arr,int p,int r) {
        int pivot = arr[r];
        int i = p;

        for (int j = 0; j < r; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr,int i,int j) {
        if (i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package com.example.dsalgo.sort;

/**
 * @Description: 向下冒泡算法
 * @Author: paladin
 * @date: 2020/9/27 20:23
 */
public class SortsAddOn {

    public static void main(String[] args) {
        int[] arr = {3, 85, 4168, 435, 1746, 3, 841351, 638168, 54684, 643, 163, 85164, 684668435};
        int len = arr.length;
        //        bubbleSort(arr);
//        insertionSort(arr);
//        selectionSort(arr);
//        mergeSort(arr, 0, 12);
        bubbleDownSort(arr);
        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleDownSort(int[] a){
        int len = a.length;
        if (len <= 1) {
            return;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    private static void shellSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }
    }
}

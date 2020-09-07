package com.example.dsalgo.sort;

/**
 * @Description: 基本排序算法的实现,可以考虑改成集合，带Comparator的排序
 * @Author: paladin
 * @date: 2020/9/6 19:57
 */
public class Sort {
    public static void main(String[] args) {
        int[] arr = {3, 85, 4168, 435, 1746, 3, 841351, 638168, 54684, 643, 163, 85164, 684668435};
        int len = arr.length;
//        bubbleSort(arr);
//        insertionSort(arr);
        selectionSort(arr);

        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 双层循环，两两比较，如果内层循环没有发生交换则说明后续数据都是有序不需要继续比较
     * @param a 需要排序的数组
     * @return 排序结果
     */
    public static void bubbleSort(int[] a) {
        int len = a.length;
        if (len <= 0) {
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = 0; i + j + 1 < len; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    // 发生了数据交换
                    flag = true;
                }
            }
            // 没有数据交换，退出循环
            if (!flag) {
                break;
            }
        }
    }

    public static void insertionSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }

        for (int i = 1; i  < len; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    public static void selectionSort(int[] a) {
        int len = a.length;
        if (len <= 1) {
            return;
        }

        for (int i = 0; i + 1 < len; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            int temp = 0;
            temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
    }

}

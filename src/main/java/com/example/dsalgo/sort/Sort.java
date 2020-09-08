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
//        selectionSort(arr);
        mergeSort(arr, 0, 12);

        for (int i = 0; i < len; i++) {
            System.out.println(arr[i]);
//            System.out.println("i " + i + " >>1 " + (i >> 1));
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

    public static void mergeSort(int[] a,int p,int r) {
        if (p >= r) {
            return;
        }

        // 取p和r的中间位置q，防止(p+r)的和超过int类型最大值
        // 为什么用位运算会报错？
        int q = p + (r - p) / 2;
        mergeSort(a, p, q);
        mergeSort(a, q + 1, r);
        merge(a, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] temp = new int[r - p + 1];

        // 合并数组
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            }else {
                temp[k++] = a[j++];
            }
        }

        // 判断子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            temp[k++] = a[start++];
        }

        // 将temp中的数据拷贝回去
        for (int l = 0; l < r - p + 1; l++) {
            a[p + l] = temp[l];
        }
    }


    public static void quickSort(int[] a,int p,int r) {
        if (p >= r) {
            return;
        }

        // 获取分区点
        int q = partition(a, p, r);
        quickSort(a, p, q - 1);
        quickSort(a, q + 1, r);
        
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = 0; j < r; j++) {
            if (a[j] < pivot) {
                if(i == j){
                    ++i;
                }else{
                    int temp = a[i];
                    a[i++] = a[j];
                    a[j] = temp;
                }
            }
        }
        int temp = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i;
    }
}

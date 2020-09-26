package com.example.dsalgo.queue;

/**
 * @Description: 循环队列
 * @Author: paladin
 * @date: 2020/9/26 16:28
 */
public class CircularQueue {

    private String[] items;
    private int n = 0;

    private int head;
    private int tail;

    public CircularQueue( int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item) {
        // 队列满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        // 处理循环的末尾到头部
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        // 处理循环的末尾到头部
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) {
            return;
        }
        for (int i = head; i % n != tail; i = (i + 1) % n) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

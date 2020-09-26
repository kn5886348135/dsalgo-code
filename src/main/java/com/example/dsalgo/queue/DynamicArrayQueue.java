package com.example.dsalgo.queue;

/**
 * @Description: 基于动态数组实现的队列
 * @Author: paladin
 * @date: 2020/9/26 20:19
 */
public class DynamicArrayQueue {
    private String[] items;
    private int n = 0;
    private int head;
    private int tail;

    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    public boolean enqueue(String item){
        if (tail == n) {
            // 队列满
            if (head == 0) {
                return false;
            }
            // 数据搬移，不使用System.arraycopy，需要额外使用一个数组
            for (int i = head; i < tail; i++) {
                items[i-head] = items[i];
            }
        }
        tail -= head;
        head = 0;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}

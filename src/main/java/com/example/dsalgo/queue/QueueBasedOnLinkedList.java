package com.example.dsalgo.queue;

/**
 * @Description: 基于链表实现的队列
 * @Author: paladin
 * @date: 2020/9/26 21:08
 */
public class QueueBasedOnLinkedList {
    private Node head=null;
    private Node tail=null;

    public void enqueue(String item) {
        Node node = new Node(item, null);
        if (tail == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        head = head.next;
        // tail置为空
        if (head == null) {
            tail = null;
        }
        String ret = head.getData();
        return ret;
    }

    public void printAll() {
        Node p = head;
        while (null != p) {
            System.out.print(p.getData() + " ");
            p = p.next;
        }
        System.out.println();
    }
    
    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }
}

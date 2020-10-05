package com.example.dsalgo.hashtable;

import java.util.HashMap;

/**
 * @Description: 基于散列表的LRU算法
 * @Author: paladin
 * @date: 2020/10/5 20:32
 */
public class LRUBasedOnHashTable<K,V> {

    public static final int DEFAULT_CAPACITY = 10;

    private DoubleNode<K, V> headNode;
    private DoubleNode<K, V> tailNode;
    // 链表长度
    private int length;
    // 链表容量
    private int capacity;

    private HashMap<K, DoubleNode<K, V>> table;

    public LRUBasedOnHashTable(int capacity) {
        this.length = 0;
        this.capacity = capacity;
        headNode = new DoubleNode<>();
        tailNode = new DoubleNode<>();
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }

    public LRUBasedOnHashTable() {
        this(DEFAULT_CAPACITY);
    }

    public void add(K key, V value) {
        DoubleNode<K, V> node = table.get(key);
        if (node == null) {
            DoubleNode<K, V> newNode = new DoubleNode<>(key, value);
            table.put(key, newNode);
            addNode(newNode);
            if (++length > capacity) {
                DoubleNode<K, V> tail = popTail();
                table.remove(tail.key);
                length--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addNode(DoubleNode<K, V> newNode) {
        newNode.next = headNode.next;
        newNode.prev = headNode;
        headNode.next.prev = newNode;
        headNode.next = newNode;
    }

    private DoubleNode<K, V> popTail() {
        DoubleNode<K, V> node = tailNode.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(DoubleNode<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DoubleNode<K, V> node) {
        removeNode(node);
        addNode(node);
    }

    public V get(K key) {
        DoubleNode<K, V> node = table.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void remove(K key) {
        DoubleNode<K, V> node = table.get(key);
        if (node == null) {
            return;
        }
        removeNode(node);
        length--;
        table.remove(node.key);
    }

    private void printAll() {
        DoubleNode<K, V> node = headNode.next;
        while (node.next != null) {
            System.out.print(node.value + ",");
            node=node.next;
        }
        System.out.println();
    }
    
    /**
     * 双向链表
     */
    static class DoubleNode<K,V> {
        private K key;
        private V value;
        // 前驱指针
        private DoubleNode<K,V> prev;
        // 后继指针
        private DoubleNode<K,V> next;

        public DoubleNode() {
        }

        private DoubleNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

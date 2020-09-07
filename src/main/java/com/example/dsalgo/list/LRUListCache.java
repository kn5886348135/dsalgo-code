package com.example.dsalgo.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:05
 */
public class LRUListCache<T> {

    int size;
    Node<T> first;
    Node<T> last;
    int length = 100;

    /**
     * 1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
     * 2. 如果此数据没有在缓存链表中，又可以分为两种情况：
     *      如果此时缓存未满，则将此结点直接插入到链表的头部；
     *      如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
     * @param t
     * @return
     */
    public boolean add(T t) {
        Node<T> node = first;
        Node<T> data = new Node<>(t, null, null);
        // 如果已经存在则删除该元素并重新插入到链表头部
        for (int i = 0; i < size; i++) {
            if (node.item.equals(t)) {
                Node<T> prev = node.prev;
                prev.next = node.next;
                node.next.prev = prev;
                node = null;
                Node<T> f = first;
                first = data;
                data.next = f;
                f.prev = data;
                return true;
            }
            node = node.next;
        }

        if (size < length) {
            Node<T> f = first;
            first = data;
            data.next = f;
            f.prev = data;
            size++;
            return true;
        }else {
            Node<T> l = last;
            last = l.prev;
            l = null;

            Node<T> f = first;
            first = data;
            data.next = f;
            f.prev = data;
            return true;
        }
    }

    T get(T t){
        Node<T> data = first;
        for (int i = 0; i < size; i++) {
            if (data.item.equals(t)) {
                return data.item;
            }
        }
        return null;
    }

    private class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}

package com.example.dsalgo.list;


/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:10
 */
public class DoubleCircularLinkedList<T> {
    Node<T> first;
    Node<T> last;
    int size;

    private class Node<T>{
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(T item, Node<T> next, Node<T> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }


    public boolean add(T item) {
        Node<T> data = new Node<>(item, null, null);
        Node<T> l = last;
        last = data;
        if (l == null) {
            first = data;
        } else {
            l.next = data;
            data.prev = l;
        }
        size++;
        return true;
    }

    public boolean remove(T item) {
        Node<T> data = first;
        for (int i = 0; i < size; i++) {
            if (data.item.equals(item)) {
                Node<T> prev = data.prev;
                Node<T> next = data.next;
                prev.next = next;
                next.prev = prev;
                size--;
                return true;
            }
            data = data.next;
        }
        return false;
    }

    public boolean set(T item,T element) {
        Node<T> data = first;
        for (int i = 0; i < size; i++) {
            if (data.item.equals(item)) {
                data.item = element;
                return true;
            }
        }
        return false;
    }

    public T get(int index) {
        Node<T> data = first;
        for (int i = 0; i < index; i++) {
            data = data.next;
        }
        return data.item;
    }
}

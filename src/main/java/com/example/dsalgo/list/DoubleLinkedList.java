package com.example.dsalgo.list;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:10
 */
public class DoubleLinkedList<T> {
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

    public boolean add(T data) {
        final Node<T> l = last;
        final Node<T> node = new Node<>(data, null, null);
        last = node;
        if (l == null) {
            first = node;
        }else{
            l.next = node;
            node.prev = l;
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
//                if (prev == null) {
//                    Node<T> f = first;
//                    first = node;
//                    node.next = f.next;
//                }
//                if (last == null) {
//                    Node<T> l = last;
//                    last = node;
//                }
                prev.next = next;
                next.prev = prev;
                data = null;
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
            data = data.next;
        }
        return false;
    }

    public T get(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

}

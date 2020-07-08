package com.example.dsalgo.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:09
 */
public class SinglyLinkedList<E> implements List<E>{

    Node<E> first;
    Node<E> last;
    private Node<E> next;

    int size;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public java.util.List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        final Node<E> l = last;
        Node<E> node = new Node(e, next);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    private class Node<E>{
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }


    public boolean removeIndex(int index){
        Node<E> data = first;
        for (int i = 0; i < index; ++i) {
            data = data.next;
        }
        Node<E> pre = first;

        for (int i = 0; i < index - 1; ++i) {
            pre = pre.next;
        }
        Node<E> suffix = data.next;

        if (index == 0) {
            first = data.next;
            data.next = null;
        }

        pre.next = suffix;
        data.next = null;
        data.item = null;
        size--;
        return true;
    }

    public boolean removeElement(E item){
        Node<E> data = first;

        if (first.item.equals(item)) {
            first = data.next;
            data.next = null;
        }
        if (last.item.equals(item)) {

        }
        for (int i = 0; i < size; ++i) {
            data = data.next;
            if (data.next.item.equals(item)) {
                data.next = data.next.next;
                data.next.next = null;
            }
        }
        return true;
    }

    public boolean set(E data, E element) {
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (node.item.equals(data)) {
                node.item = element;
                node = node.next;
                continue;
            }
            node = node.next;
        }
        return true;
    }

    public E get(int index){
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

}

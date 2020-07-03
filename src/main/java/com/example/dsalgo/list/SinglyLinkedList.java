package com.example.dsalgo.list;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:09
 */
public class SinglyLinkedList<T> {

    Node<T> first;
    Node<T> last;
    private Node<T> next;

    int size;
    private class Node<T>{
        T item;
        Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public boolean add(T data){
        final Node<T> l = last;
        Node<T> node = new Node(data, next);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
        return true;
    }

    public boolean removeIndex(int index){
        Node<T> data = first;
        for (int i = 0; i < index; ++i) {
            data = data.next;
        }
        Node<T> pre = first;

        for (int i = 0; i < index - 1; ++i) {
            pre = pre.next;
        }
        Node<T> suffix = data.next;

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

    public boolean removeElement(Node<T> node){
        Node<T> data = first;

        if (first.equals(node)) {
            first = data.next;
            data.next = null;
        }
        if (last.equals(node)) {

        }
        for (int i = 0; i < size; ++i) {
            data = data.next;
            if (data.next.item.equals(node.item)) {
                data.next = data.next.next;
                data.next.next = null;
            }
        }
        return true;
    }

    public boolean set(T data, T element) {
        Node<T> node = first;
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

    public T get(int index){
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        list.add("sdgasd");
        list.add("sdags");
        list.add("sdgsadgsdasd");
        list.add("asdhsfs");
        list.add("sadhgdsf");

        int size = list.size;
        for (int i = 0; i < size; i++) {
            String a = list.get(i);
            System.out.println(a);
        }
        list.removeIndex(1);
        size = list.size;
        System.out.println("=========");
        for (int i = 0; i < size; i++) {
            String a = list.get(i);
            System.out.println(a);
        }
        System.out.println("===================");
        list.add("sdgasd");
        size = list.size;
        list.set("sdgasd", "aaaaaaaaaaaaa");
        for (int i = 0; i < size; i++) {
            String a = list.get(i);
            System.out.println(a);
        }
    }

}

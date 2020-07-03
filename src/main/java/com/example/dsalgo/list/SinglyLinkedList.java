package com.example.dsalgo.list;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:09
 */
public class SinglyLinkedList<T> {

    Node<T> first;
    Node<T> last;

    int size;
    private class Node<T>{
        T item;
        Node<T> next;



        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }


    private Node next;

    public boolean add(T data){
        final Node l = last;
        Node newnode = new Node(data, next);
        last = newnode;
        if (l == null) {
            first = newnode;
        } else {
            l.next = newnode;
        }
        size++;
        return true;
    }

    public boolean remove(int index){
        Node<T> data = first;
        for (int i = 0; i < index; ++i) {
            data = data.next;
        }
        Node<T> pre = first;
//        Node<T> node = null;
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
    public boolean remove(Node<T> node){
        Node<T> data = first;

        if (first.equals(node)) {
            first = data.next;
            data.next = null;
        }
        if (last.equals(node)) {

        }
        for (int i = 0; i < size; ++i) {
            Node<T> pre = data;
            data = data.next;
            if (data.next.item.equals(node.item)) {
                data.next = data.next.next;
                data.next.next = null;
            }
        }
        return false;
    }


    public boolean set(Node data){

        return false;
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
        list.remove(1);
        size = list.size;
        System.out.println("=========");
        for (int i = 0; i < size; i++) {
            String a = list.get(i);
            System.out.println(a);
        }
    }

}

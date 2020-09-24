package com.example.dsalgo.stack;

/**
 * @Description: 基于链表实现的栈
 * @Author: paladin
 * @date: 2020/9/24 20:12
 */
public class StackBasedOnLinkedList {
    private int size;
    private Node top = null;

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(2);
        stack.push(21351);
        stack.push(27675);
        stack.push(2285443);
        stack.push(2532854);
        stack.push(22854);
        stack.push(22253);
        stack.push(2235);
        stack.push(2369656);
        stack.push(2353);
        stack.push(2428546);
        stack.push(2583564);
        stack.push(237696);
        stack.push(2785976);
        stack.push(224543);
        stack.printAll();
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");
        System.out.print(stack.pop()+" ");

    }

    public void push(int value) {
        Node data = new Node(value, null);
        if (top == null) {
            top = data;
        }else {
            data.next = top;
            top = data;
        }
    }

    public int pop() {
        if (top == null) {
            return -1;
        }
        int value = top.getData();
        top = top.next;
        return value;
    }


    public void printAll(){
        Node p = top;
        while (p != null) {
            System.out.print(p.getData()+" ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}

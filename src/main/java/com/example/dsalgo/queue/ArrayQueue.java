package com.example.dsalgo.queue;   

/**
 * @Description: 数组实现的队列
 * @Author: paladin
 * @date: 2020/9/24 20:53
 */
public class ArrayQueue {

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.enqueue("dshads");
        queue.enqueue("ahrhre");
        queue.enqueue("sgfkghregwergwe");
        queue.enqueue("sahrdfgvefwe");
        queue.enqueue("szhnrgrfhnjtrge");
        queue.enqueue("adsjregwerhgr");
        queue.enqueue("ahfdds");
        queue.enqueue("ahfddshrehre");
        queue.enqueue("sajfdgdjerer236");
        queue.enqueue("dfasjdf769");
        queue.enqueue("ffgdf234754");
        queue.enqueue("dsfjgfhdf097");
        queue.printAll();
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");

        queue.enqueue("adfjfddaf132634");
        queue.enqueue("13634532jfdjfyger");
        queue.enqueue("13634532jfdjfyger");
        queue.enqueue("13634532jfdjjt5rggwegfyger");
        queue.enqueue("sdfjhdfsr");
        queue.enqueue("dfhddfsjtrf");
        queue.enqueue("sadfhre");
        queue.enqueue("dsfjdfg");
        queue.enqueue("dfjher");
        queue.enqueue("13634532jfsdfhdfdjfyger");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");
        System.out.print(queue.dequeue()+" ");

        queue.enqueue("ahfdds");
    }

    public ArrayQueue(int n) {
        items = new String[n];
        this.n = n;
    }

    public boolean enqueue(String item){
        // 数组满
        if (tail == n && head == 0) {
            return false;
        }
        if (tail == n) {
            String[] newItems = new String[n];
            System.arraycopy(items, 0, newItems, head, tail - head);
            tail = tail - head;
            head = 0;
            items = newItems;
            items[tail] = item;
            tail++;
            return true;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue(){
        if (head == tail) {
            return "";
        }
        String ret = items[head];
        head++;
        return ret;
    }

    public void printAll(){
        for (int i = head; i < tail; i++) {
            System.out.print(items[i]+" ");
        }
        System.out.println();
        System.out.println("traverse over");
    }
}

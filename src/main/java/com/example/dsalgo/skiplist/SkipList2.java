package com.example.dsalgo.skiplist;


import java.util.Random;

/**
 * @Description: 跳表实现的另一种方法,跳表中存储的是正整数，并且是不重复的。
 * @Author: paladin
 * @date: 2020/10/3 13:45
 */
public class SkipList2 {

    public static final int MAX_LEVEL = 16;
    private int levelCount = 1;

    private Node head = new Node(MAX_LEVEL);
    private Random random = new Random();

    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }

    }
    /**
     * 跳表的节点，每个节点记录了当前节点数据和所在层数数据
     */
    public class Node {
        private int data = -1;
        private Node forwards[];
        private int maxLevel = 0;

        public Node(int level) {
            this.forwards = new Node[level];
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append(";  levels: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SkipList2 list = new SkipList2();
    }
}

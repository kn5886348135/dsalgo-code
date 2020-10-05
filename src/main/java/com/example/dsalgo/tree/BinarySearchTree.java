package com.example.dsalgo.tree;

/**
 * @Description: 二叉搜索树
 * @Author: paladin
 * @date: 2020/10/5 21:26
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data){
        Node p = tree;
        while (p != null) {
            if (data < p.data) {
                p = p.left;
            }else if (data > p.data) {
                p = p.right;
            }else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }else {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree;
        Node parent = null;
        while (p != null && p.data != data) {
            parent=p;
            if (data > p.data) {
                p = p.right;
            }else {
                p = p.left;
            }
        }
        if (p.left != null && p.right != null) {
            Node minp = p.right;
            Node minParent = p;
            while (minp.left != null) {
                minParent = minp;
                minp = minp.left;
            }
            p.data = minp.data;
            p = minp;
            parent = minParent;
        }

        Node child;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }else {
            child = null;
        }
        if (parent == null) {
            tree = child;
        } else if (parent.left == p) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    public Node findMin(){
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    
    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}

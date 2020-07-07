package com.example.dsalgo.list;

/**
 *  @author: paladin
 *  @date: created in 2020/7/7 20:07
 */
public class ListTest {
    public static void main(String[] args) {

//        singlyLinkedListTest();
        doubleLinkedListTest();

    }

    private static void singlyLinkedListTest() {
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

    private static void doubleLinkedListTest() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("adherents");
        list.add("adhere");
        list.add("onmessage");
        list.add("giddier");
        list.add("adjudged");
        list.add("hakluyt's");
        list.add("firebug");
        int size = list.size;
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("=================");
        list.remove("adhere");
        size = list.size;
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }

        System.out.println("=================");
        list.set("firebug", "teletypewriter");
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }
}

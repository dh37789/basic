package com.algorithm.e_linkedList;

import java.util.List;

public class LinkedMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst("A");
        list.addLast("C");
        list.add(1, "B");
        list.addLast("E");
        list.add(3,"D");
        System.out.println(list.removeFirst());
        System.out.println(list.removeLast());
        System.out.println(list.remove(1));


        System.out.println(list.size());
        System.out.println(list.toString());

        list.clear();

        System.out.println(list.size());
        System.out.println(list.toString());
    }
}

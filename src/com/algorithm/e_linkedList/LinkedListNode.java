package com.algorithm.e_linkedList;

public class LinkedListNode<T> {
    T data;
    LinkedListNode<T> link;

    public LinkedListNode(T data){
        this.data = data;
        this.link = null;
    }
}

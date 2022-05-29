package com.algorithm.c_stack;

public class StackNode<T> {

  T item;
  StackNode next;

  public StackNode() {
    this.next = null;
  }

  public StackNode(T item) {
    this.item = item;
    this.next = null;
  }
}

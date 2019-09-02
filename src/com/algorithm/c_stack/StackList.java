package com.algorithm.c_stack;

import java.util.NoSuchElementException;

public class StackList<T> {

  StackNode<T> top;

  public void push(T data) {
    StackNode nd = new StackNode(data);
    nd.next = top;
    top = nd;
  }

  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Stack Null");
    }
    return top.item;
  }

  public T pop() {
    T item = peek();
    top = top.next;
    return item;
  }

  public boolean isEmpty() {
    return (top == null);
  }
}

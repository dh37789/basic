package com.example.c_stack;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class StackArr {

  int top;
  int MAX_SIZE;
  Object[] arr;

  public StackArr(int MAX_SIZE) {
    top = -1;
    this.MAX_SIZE = MAX_SIZE;
    arr = new Object[MAX_SIZE];
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public void push(Object obj) {
    if (MAX_SIZE - 1 == top) {
      throw new ArrayIndexOutOfBoundsException("Max Stack : " + MAX_SIZE);
    }
    arr[++top] = obj;
  }

  public Object peek() {
    if (isEmpty()) {
      throw new ArrayIndexOutOfBoundsException("Stack Empty..");
    }
    return arr[top];
  }

  public Object pop() {
    Object obj = peek();
    top--;
    return obj;
  }

}

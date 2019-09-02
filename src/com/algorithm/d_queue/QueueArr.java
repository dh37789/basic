package com.algorithm.d_queue;

import java.util.NoSuchElementException;

public class QueueArr {

  int front;
  int rear;
  int MAX_SIZE;
  Object[] queueArr;

  public QueueArr(int MAX_SIZE) {
    this.front = 0;
    this.rear = -1;
    this.MAX_SIZE = MAX_SIZE;
    queueArr = new Object[MAX_SIZE];
  }

  public boolean isEmpty() {
    if (front > rear) {
      return true;
    }
    return false;
  }

  public Object peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue Empty!!");
    }
    Object item = queueArr[front];
    return item;
  }

  public void enqueue(Object item) {
    if (MAX_SIZE == rear) {
      throw new NoSuchElementException("Queue Full!!");
    }
    queueArr[++rear] = item;
  }

  public Object dequeue() {
    Object item = peek();
    front++;
    return item;
  }
}

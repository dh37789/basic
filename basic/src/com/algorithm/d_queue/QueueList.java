package com.algorithm.d_queue;

import java.util.NoSuchElementException;

public class QueueList<T> {

  private QueueNode<T> front;
  private QueueNode<T> rear;

  public QueueList() {
    this.front = null;
    this.rear = null;
  }

  public boolean isEmpty() {
    if (front == null) {
      return true;
    }
    return false;
  }

  public void enqueue(T item) {
    QueueNode<T> node = new QueueNode<>(item);
    if (isEmpty()) {
      front = node;
      rear = node;
    } else {
      rear.next = node;
      rear = node;
    }
  }

  public T peek() {
    if (isEmpty()) {
      throw new NoSuchElementException("Queue Empty!!");
    }
    return front.item;
  }

  public T dequeue() {
    T item = peek();
    front = front.next;
    if (front == null) {
      rear = null;
    }
    return item;
  }
}

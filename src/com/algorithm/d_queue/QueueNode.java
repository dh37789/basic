package com.algorithm.d_queue;

public class QueueNode<T> {

  T item;
  QueueNode next;

  public QueueNode() {
    this.next = null;
  }

  public QueueNode(T item) {
    this.item = item;
  }
}

package com.algorithm.d_queue;

public class QueueMain {

  public static void main(String[] args) {

    QueueArr queueArr = new QueueArr(5);

    queueArr.enqueue("Hello");
    queueArr.enqueue("Java");
    System.out.println(queueArr.peek());
    queueArr.dequeue();
    queueArr.enqueue("!!!!!");
    System.out.println(queueArr.peek());

    QueueList queueList = new QueueList();

    queueList.enqueue("Have");
    queueList.enqueue("Nice");
    queueList.enqueue("day");
    queueList.enqueue("!!!!");
    queueList.dequeue();
    queueList.dequeue();
    queueList.dequeue();
    queueList.dequeue();
    System.out.println(queueList.peek());
  }

}

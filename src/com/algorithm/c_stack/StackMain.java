package com.algorithm.c_stack;

public class StackMain {

  public static void main(String[] args) {

//    stackTest1();
    stackTest2();

  }

  private static void stackTest1() {
    StackArr stackArr = new StackArr(5);

    stackArr.push("Hello");
    stackArr.push("World");
    stackArr.pop();
    System.out.println(stackArr.isEmpty());
    stackArr.pop();
    System.out.println(stackArr.isEmpty());
    stackArr.push("!!!!!");
    stackArr.push("!!!!!");

    System.out.println(stackArr.peek());
  }

  private static void stackTest2() {
    StackList stackList = new StackList();

    stackList.push("Hello");
    stackList.push("World");
    stackList.push("!!!!!");
    stackList.push("22222");
    stackList.push("33333");
    stackList.pop();

    System.out.println(stackList.peek());

  }

}

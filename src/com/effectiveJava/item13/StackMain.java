package com.effectiveJava.item13;

public class StackMain {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);

        System.out.println("stack size : " + stack.getSize());
        System.out.println("stack elements : " + stack.elements);
        System.out.println("stack : " + stack);

        Stack clone = stack.clone();
        System.out.println("clone size : " + clone.getSize());
        System.out.println("clone elements : " + clone.elements);
        System.out.println("clone : " + clone);
    }
}

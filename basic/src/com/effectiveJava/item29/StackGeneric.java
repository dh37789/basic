package com.effectiveJava.item29;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

public class StackGeneric<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public StackGeneric() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    public void popAll(Collection<? super E> list) {
        while (!isEmpty())
            list.add((E) pop());
    }

    public void pushAll(Iterable<? extends E> iter) {
        for (E e : iter)
            push(e);
    }
}

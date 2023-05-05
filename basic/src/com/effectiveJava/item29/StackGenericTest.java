package com.effectiveJava.item29;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StackGenericTest {

    @Test
    void pushAll_테스트() {
        StackGeneric<Number> numberStack = new StackGeneric<>();
        Iterable<Integer> integers = List.of(1, 2, 3);
        numberStack.pushAll(integers);
    }

    @Test
    void popAll_테스트() {
        StackGeneric<Number> numberStack = new StackGeneric<>();
        Collection<Object> objects = Arrays.asList(new Object(), new Object());
        numberStack.popAll(objects);
    }

    @Test
    void swap_테스트() {
        swap(List.of(1,2,3), 1, 2);
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

}
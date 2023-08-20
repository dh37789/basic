package com.effectiveJava.item79;

@FunctionalInterface
public interface SetObserverRefactor<E> {
    /* ObservableSet에 원소가 더해지면 호출된다. */
    void added(ObservableSetRefactor<E> set, E element);
}

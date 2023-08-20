package com.effectiveJava.item79;

import com.effectiveJava.item18.compositionSet.ForwardingSet;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ObservableSetRefactor<E> extends ForwardingSet<E> {
    public ObservableSetRefactor(Set<E> set) { super(set); }

    private final List<SetObserverRefactor<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserverRefactor<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(SetObserverRefactor<E> observer) {
        return observers.remove(observer);
    }

    private void notifyElementAdded(E element) {
        for (SetObserverRefactor<E> observer : observers)
            observer.added(this, element);
    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added)
            notifyElementAdded(element);
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c)
            result |= add(element); /* notifyElementAdded를 호출한다. */
        return result;
    }
}

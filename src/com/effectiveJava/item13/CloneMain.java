package com.effectiveJava.item13;

import java.util.HashSet;
import java.util.TreeSet;

public class CloneMain {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("apple");
        hashSet.add("banana");

        TreeSet<String> clone = (TreeSet<String>) hashSet.clone();
        System.out.println(clone.first());
        System.out.println(clone.last());

        TreeSet<String> copy = new TreeSet<>(hashSet);
        System.out.println(copy.first());
        System.out.println(copy.last());
    }
}

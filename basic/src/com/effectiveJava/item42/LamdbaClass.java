package com.effectiveJava.item42;

import java.util.List;

import static java.util.Comparator.comparingInt;

public class LamdbaClass {
    public static void main(String[] args) {
        List<String> words = List.of("a", "b", "c");
        words.sort(comparingInt(String::length));
    }
}

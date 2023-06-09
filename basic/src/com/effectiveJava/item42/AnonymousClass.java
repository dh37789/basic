package com.effectiveJava.item42;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClass {
    public static void main(String[] args) {
        List<String> words = List.of("a", "b", "c");
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }
}

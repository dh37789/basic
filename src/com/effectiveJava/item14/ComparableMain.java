package com.effectiveJava.item14;

import java.math.BigDecimal;
import java.util.*;

public class ComparableMain {
    public static void main(String[] args) {
        String[] array = {"a","b","c"};
        Arrays.sort(array);

        Set<String> s = new TreeSet<>();
        s.add("apple");
        s.add("banana");
        s.add("carrot");
        s.add("apple");
        Collections.addAll(s, args);
        System.out.println(s);

        BigDecimal decimal1 = new BigDecimal("1.0");
        BigDecimal decimal2 = new BigDecimal("1.00");
        BigDecimal decimal3 = new BigDecimal("1.000");

        HashSet<BigDecimal> hashSet = new HashSet<>();
        hashSet.add(decimal1);
        hashSet.add(decimal2);
        hashSet.add(decimal3);

        TreeSet<BigDecimal> treeSet = new TreeSet<>();
        treeSet.add(decimal1);
        treeSet.add(decimal2);
        treeSet.add(decimal3);

        System.out.println("HashSet size : " + hashSet.size());
        System.out.println("TreeSet size : " + treeSet.size());

    }
}

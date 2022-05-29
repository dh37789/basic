package com.algorithm;

public class Test {
    public static void main(String[] args) {
        String physicalStr1 = "abc";
        String physicalStr2 = "abc";
        String physicalStr3 = new String("abc");
        StringBuilder physicalSb1 = new StringBuilder("abc");
        StringBuilder physicalSb2 = new StringBuilder("abc");

        System.out.println(physicalStr1 == physicalStr2); /* true */
        System.out.println(physicalStr2 == physicalStr3); /* false */
        System.out.println(physicalSb1 == physicalSb2); /* false */

        String logicalStr1 = "abc";
        String logicalStr2 = "abc";
        String logicalStr3 = new String("abc");
        StringBuilder logicalSb1 = new StringBuilder("abc");
        StringBuilder logicalSb2 = new StringBuilder("abc");

        System.out.println(logicalStr1.equals(logicalStr2)); /* true */
        System.out.println(logicalStr2.equals(logicalStr3)); /* true */
        System.out.println(logicalSb1.equals(logicalSb2)); /* false */
    }
}

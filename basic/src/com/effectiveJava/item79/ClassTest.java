package com.effectiveJava.item79;

public class ClassTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        OutClass.InClass in = new OutClass().new InClass();
        System.out.println(in.inStr);
    }
}

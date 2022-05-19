package com.effectiveJava.item18;

/**
 * 자식 상속객체
 */
public class Dog extends Animal {
    public String stringToDog() {
        return "나는 개입니다. " + stringToAnimal();
    }
}

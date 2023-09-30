package com.design.pattern._01_creational_patterns._04_singleton;

/**
 * private 생성자와 public static 메소드를 사용하는 방법
 */
public class Singleton1 {

    private static Singleton1 instance;
    private Singleton1() {}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }

        return instance;
    }
}

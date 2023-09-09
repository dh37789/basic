package com.design.pattern._01_creational_patterns._04_singleton;

/**
 * double checked locking 방법 사용한 싱글톤 생성 방법
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null)
                    instance = new Singleton3();
            }
        }
        return instance;
    }
}

package com.design.pattern._01_creational_patterns._04_singleton;

public class Singleton4 {
    private Singleton4() { }

    private static class Singleton4Holder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return Singleton4Holder.INSTANCE;
    }
}

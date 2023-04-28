package com.effectiveJava.item24;

import java.util.AbstractList;
import java.util.HashMap;
import java.util.List;

public class MyMap {
    HashMap<String, String> map;

    public List anonymousFunction() {
        return new AbstractList() {
            @Override
            public Object get(int index) {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }

    public void localClass() {
        class LocalClass {
            private Long id;
            private String name;

            public LocalClass(Long id, String name) {
                this.id = id;
                this.name = name;
            }

            public Long getId() {
                return id;
            }

            public String getName() {
                return name;
            }

        }

        LocalClass local = new LocalClass(1L, "mho");
        System.out.println(local.getId());
        System.out.println(local.getName());
    }
}

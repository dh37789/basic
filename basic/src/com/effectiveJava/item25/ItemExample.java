package com.effectiveJava.item25;

import java.util.*;

public class ItemExample {

    public static void main(String[] args) {
        Collection<?> members = new ArrayList<>();
//        members.add(new Member(1L, "mho1"));
//        members.add(1);
//        members.add("mho");
        members.add(null);
    }

    private static void example3() {
        List<String> strings = new ArrayList<>();
//        unsafeAdd(strings, Integer.valueOf(101));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List<Object> list, Integer o) {
        list.add(o);
    }

    private static void example2() {
        final Collection<Stamp> stamps = new ArrayList();
//        stamps.add(new Coin(500));

//        final Collection<Stamp> stamps = new ArrayList<>();
//        stamps.add(new Stamp("square"));

        for (Iterator i = stamps.iterator(); i.hasNext();) {
            Stamp stamp = (Stamp) i.next();
            stamp.stamp();
        }
    }

    public void example1() {
        Collection<?> members = new ArrayList<>();
//        members.add(new Member(1L, "mho1"));
//        members.add(1);
//        members.add("mho");
        members.add(null);
    }

    private static class Coin {
        private Integer price;

        public Coin(Integer price) {
            this.price = price;
        }
    }

    private static class Stamp {
        private String type;

        public void stamp() {
            System.out.println(this.type + "모양의 도장을 찍었습니다.");
        }

        public Stamp(String type) {
            this.type = type;
        }
    }

    private static class Member {
        private Long id;
        private String name;

        public Member(Long id, String name) {
            this.id = id;
            this.name = name;
        }
    }

}

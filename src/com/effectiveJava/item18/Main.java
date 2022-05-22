package com.effectiveJava.item18;

import com.effectiveJava.item18.composition.Human;
import com.effectiveJava.item18.compositionSet.InstrumentedSet;
import com.effectiveJava.item18.inheritance.Dog;
import com.effectiveJava.item18.inheritanceSet.InstrumentedHashSet;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        /* IS-A 관계 */
        Dog dog = new Dog();
        System.out.println(dog.stringToDog());

        /* HAS-A 관계 */
        Human human = new Human();
        System.out.println(human.stringToHuman());

        /* 상속의 잘못된 예시 */
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(List.of("apple", "banana", "cat"));
        System.out.println("set size : " + set.getAddCount());

        /* Set의 컴포지션 */
        Set<String> set2 = new InstrumentedSet<>(new TreeSet<>(List.of("apple", "banana", "cat")));
        System.out.println("set size : " + set2.size());
    }
}

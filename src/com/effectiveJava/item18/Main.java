package com.effectiveJava.item18;

public class Main {
    public static void main(String[] args) {
        /* IS-A 관계 */
        Dog dog = new Dog();
        System.out.println(dog.stringToDog());

        /* HAS-A 관계 */
        Human human = new Human();
        System.out.println(human.stringToHuman());
    }
}

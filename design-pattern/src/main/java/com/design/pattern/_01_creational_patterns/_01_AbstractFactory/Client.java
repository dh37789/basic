package com.design.pattern._01_creational_patterns._01_AbstractFactory;

import com.design.pattern._01_creational_patterns._01_AbstractFactory.abstractFactory.AbstractFactory;
import com.design.pattern._01_creational_patterns._01_AbstractFactory.abstractFactory.Notebook;
import com.design.pattern._01_creational_patterns._01_AbstractFactory.abstractFactory.Television;
import com.design.pattern._01_creational_patterns._01_AbstractFactory.lg.LgFactory;
import com.design.pattern._01_creational_patterns._01_AbstractFactory.samsung.SamsungFactory;

public class Client {
    public static void main(String[] args) {
        /* LG */
        AbstractFactory lgfactory = getInstance("LG");

        Notebook lgNotebook = lgfactory.createNotebook();
        Television lgTelevision = lgfactory.createTelevision();

        System.out.println(lgNotebook.getName());
        System.out.println(lgTelevision.getName());

        /* SAMSUNG */
        AbstractFactory factory = getInstance("SAMSUNG");

        Notebook samsungNotebook = factory.createNotebook();
        Television samsungTelevision = factory.createTelevision();

        System.out.println(samsungNotebook.getName());
        System.out.println(samsungTelevision.getName());
    }

    static AbstractFactory getInstance(String brand) {
        AbstractFactory factory = null;

        if ("LG".equals(brand)) {
            factory = new LgFactory();
        } else if ("SAMSUNG".equals(brand)) {
            factory = new SamsungFactory();
        }

        return factory;
    }
}

package src.com.design.pattern.No01AbstractFactory;

import src.com.design.pattern.No01AbstractFactory.abstractFactory.AbstractFactory;
import src.com.design.pattern.No01AbstractFactory.abstractFactory.Notebook;
import src.com.design.pattern.No01AbstractFactory.abstractFactory.Television;
import src.com.design.pattern.No01AbstractFactory.lg.LgFactory;
import src.com.design.pattern.No01AbstractFactory.samsung.SamsungFactory;

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

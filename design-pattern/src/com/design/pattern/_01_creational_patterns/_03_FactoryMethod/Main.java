package com.design.pattern._01_creational_patterns._03_FactoryMethod;

import com.design.pattern._01_creational_patterns._03_FactoryMethod.concretecreator.MetalAnimalRobotStore;
import com.design.pattern._01_creational_patterns._03_FactoryMethod.concretecreator.WoodAnimalRobotStore;
import com.design.pattern._01_creational_patterns._03_FactoryMethod.creator.AnimalRobotStore;
import com.design.pattern._01_creational_patterns._03_FactoryMethod.product.AnimalRobot;

public class Main {
    public static void main(String[] args) {
        AnimalRobotStore woodStore = new WoodAnimalRobotStore();
        AnimalRobotStore metalStore = new MetalAnimalRobotStore();

        AnimalRobot woodCatRobot = woodStore.makeAnimalRobot("cat");
        AnimalRobot woodDogRobot = woodStore.makeAnimalRobot("dog");

        AnimalRobot metalCatRobot = metalStore.makeAnimalRobot("cat");
        AnimalRobot metalDogRobot = metalStore.makeAnimalRobot("dog");

        woodCatRobot.crying();
        woodDogRobot.crying();
        metalCatRobot.crying();
        metalDogRobot.crying();
    }
}

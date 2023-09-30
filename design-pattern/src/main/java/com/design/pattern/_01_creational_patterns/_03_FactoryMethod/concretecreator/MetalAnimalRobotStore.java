package com.design.pattern._01_creational_patterns._03_FactoryMethod.concretecreator;

import com.design.pattern._01_creational_patterns._03_FactoryMethod.concreteproduct.MetalCatRobot;
import com.design.pattern._01_creational_patterns._03_FactoryMethod.concreteproduct.MetalDogRobot;
import com.design.pattern._01_creational_patterns._03_FactoryMethod.creator.AnimalRobotStore;
import com.design.pattern._01_creational_patterns._03_FactoryMethod.product.AnimalRobot;

/**
 * ConcreteCreator(MyApplication)
 * 팩토리 메서드를 재정의하여 ConcreteProduct의 인스턴스를 반환합니다.
 */
public class MetalAnimalRobotStore extends AnimalRobotStore {

    @Override
    protected AnimalRobot setRobotType(String type) {
        if ("cat".equals(type)) {
            return new MetalCatRobot();
        } else if ("dog".equals(type)) {
            return new MetalDogRobot();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

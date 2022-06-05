package com.design.pattern.No03FactoryMethod.concretecreator;

import com.design.pattern.No03FactoryMethod.concreteproduct.WoodCatRobot;
import com.design.pattern.No03FactoryMethod.concreteproduct.WoodDogRobot;
import com.design.pattern.No03FactoryMethod.creator.AnimalRobotStore;
import com.design.pattern.No03FactoryMethod.product.AnimalRobot;

/**
 * ConcreteCreator(MyApplication)
 * 팩토리 메서드를 재정의하여 ConcreteProduct의 인스턴스를 반환합니다.
 */
public class WoodAnimalRobotStore extends AnimalRobotStore {

    @Override
    protected AnimalRobot setRobotType(String type) {
        if ("cat".equals(type)) {
            return new WoodCatRobot();
        } else if ("dog".equals(type)) {
            return new WoodDogRobot();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

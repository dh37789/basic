package com.design.pattern._01_creational_patterns._03_FactoryMethod.creator;

import com.design.pattern._01_creational_patterns._03_FactoryMethod.product.AnimalRobot;

/**
 * Creator(Application)
 * Product 타입의 객체를 반환하는 팩토리 메서드를 구현합니다.
 * Creator 클래스는 팩토리 메서드를 기본적으로 구현하는데, 이 구현에서는 ConcreteProduct 객체를 반환합니다.
 * 또한 Product 객체의 생성을 위해 팩토리 메서드를 호출합니다.
 */
public abstract class AnimalRobotStore {
    public AnimalRobot makeAnimalRobot(String type) {
        AnimalRobot robot = setRobotType(type);
        robot.makeRobot();
        return robot;
    }

    protected abstract AnimalRobot setRobotType(String type);
}

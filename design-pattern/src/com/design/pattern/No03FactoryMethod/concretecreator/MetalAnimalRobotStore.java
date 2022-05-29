package src.com.design.pattern.No03FactoryMethod.concretecreator;

import src.com.design.pattern.No03FactoryMethod.concreteproduct.MetalCatRobot;
import src.com.design.pattern.No03FactoryMethod.concreteproduct.MetalDogRobot;
import src.com.design.pattern.No03FactoryMethod.creator.AnimalRobotStore;
import src.com.design.pattern.No03FactoryMethod.product.AnimalRobot;

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

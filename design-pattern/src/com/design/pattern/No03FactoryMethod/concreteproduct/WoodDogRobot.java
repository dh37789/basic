package src.com.design.pattern.No03FactoryMethod.concreteproduct;

import src.com.design.pattern.No03FactoryMethod.product.AnimalRobot;

/**
 * ConcreteProduct(MyDocument)
 * Product 클래스에 정의된 인터페이스를 실제로 구현합니다.
 */
public class WoodDogRobot extends AnimalRobot {

    public WoodDogRobot() {
        type = "Wood Dog Robot";
        texture = "wood";
        cry = "bow-wow";
    }
}

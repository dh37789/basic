package com.design.pattern.No03FactoryMethod.concreteproduct;

import com.design.pattern.No03FactoryMethod.product.AnimalRobot;

/**
 * ConcreteProduct(MyDocument)
 * Product 클래스에 정의된 인터페이스를 실제로 구현합니다.
 */
public class WoodCatRobot extends AnimalRobot {

    public WoodCatRobot() {
        type = "Wood Cat Robot";
        texture = "wood";
        cry = "mew";
    }
}

package com.design.pattern._01_creational_patterns._03_FactoryMethod.concreteproduct;

import com.design.pattern._01_creational_patterns._03_FactoryMethod.product.AnimalRobot;

/**
 * ConcreteProduct(MyDocument)
 * Product 클래스에 정의된 인터페이스를 실제로 구현합니다.
 */
public class MetalCatRobot extends AnimalRobot {

    public MetalCatRobot() {
        type = "Metal Cat Toy";
        texture = "metal";
        cry = "mew";
    }
}

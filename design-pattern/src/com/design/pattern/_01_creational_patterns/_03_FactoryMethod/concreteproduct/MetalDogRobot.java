package com.design.pattern._01_creational_patterns._03_FactoryMethod.concreteproduct;

import com.design.pattern._01_creational_patterns._03_FactoryMethod.product.AnimalRobot;

/**
 * ConcreteProduct(MyDocument)
 * Product 클래스에 정의된 인터페이스를 실제로 구현합니다.
 */
public class MetalDogRobot extends AnimalRobot {

    public MetalDogRobot() {
        type = "Metal Dog Robot";
        texture = "metal";
        cry = "bow-wow";
    }
}

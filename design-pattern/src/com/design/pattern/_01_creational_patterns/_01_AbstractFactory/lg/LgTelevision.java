package com.design.pattern._01_creational_patterns._01_AbstractFactory.lg;

import com.design.pattern._01_creational_patterns._01_AbstractFactory.abstractFactory.Television;

/**
 * ProductB1
 * 개념적 B1제품 객체에 대한 인터페이스를 구현합니다.
 */
public class LgTelevision implements Television {
    @Override
    public String getName() {
        return "LG TELEVISION";
    }
}

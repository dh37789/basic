package com.design.pattern.No01AbstractFactory.samsung;

import com.design.pattern.No01AbstractFactory.abstractFactory.Television;

/**
 * ProductB2
 * 개념적 B2제품 객체에 대한 인터페이스를 구현합니다.
 */
public class SamsungTelevision implements Television {

    @Override
    public String getName() {
        return "SAMSUNG TELEVISION";
    }
}

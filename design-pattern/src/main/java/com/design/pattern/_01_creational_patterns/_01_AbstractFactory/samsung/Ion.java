package com.design.pattern._01_creational_patterns._01_AbstractFactory.samsung;

import com.design.pattern._01_creational_patterns._01_AbstractFactory.abstractFactory.Notebook;

/**
 * ProductA2
 * 개념적 A2제품 객체에 대한 인터페이스를 구현합니다.
 */
public class Ion implements Notebook {
    @Override
    public String getName() {
        return "SAMSUNG ION";
    }
}

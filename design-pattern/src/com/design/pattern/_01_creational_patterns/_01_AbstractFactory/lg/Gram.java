package com.design.pattern._01_creational_patterns._01_AbstractFactory.lg;

import com.design.pattern._01_creational_patterns._01_AbstractFactory.abstractFactory.Notebook;

/**
 * ProductA1
 * 개념적 A1제품 객체에 대한 인터페이스를 구현합니다.
 */
public class Gram implements Notebook {
    @Override
    public String getName() {
        return "LG GRAM";
    }
}

package com.design.pattern.No01AbstractFactory.lg;

import com.design.pattern.No01AbstractFactory.abstractFactory.AbstractFactory;
import com.design.pattern.No01AbstractFactory.abstractFactory.Notebook;
import com.design.pattern.No01AbstractFactory.abstractFactory.Television;

/**
 * ConcreteFactory1
 * 구체적인 제품에 대한 객체를 생성하는 연산을 구현합니다.
 */
public class LgFactory implements AbstractFactory {

    @Override
    public Notebook createNotebook() {
        return new Gram();
    }

    @Override
    public Television createTelevision() {
        return new LgTelevision();
    }
}

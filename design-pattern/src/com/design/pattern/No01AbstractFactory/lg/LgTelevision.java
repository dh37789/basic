package src.com.design.pattern.No01AbstractFactory.lg;

import src.com.design.pattern.No01AbstractFactory.abstractFactory.Television;

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

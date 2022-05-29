package src.com.design.pattern.No01AbstractFactory.samsung;

import src.com.design.pattern.No01AbstractFactory.abstractFactory.Notebook;

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

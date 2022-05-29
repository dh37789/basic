package src.com.design.pattern.No02Builder.builder;

import src.com.design.pattern.No02Builder.product.Hamburger;

/**
 * Builder
 * Product 객체의 일부 요소들을 생성하기 위한 추상 인터페이스를 정의합니다.
 */
public abstract class HamburgerBuilder {
    protected Hamburger hamburger;

    public Hamburger createHamburger() {
        return hamburger;
    }

    public void prepareNewHamburger() {
        hamburger = new Hamburger();
    }

    public abstract void setHamburger();
}

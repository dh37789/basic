package src.com.design.pattern.No02Builder.director;

import src.com.design.pattern.No02Builder.builder.HamburgerBuilder;
import src.com.design.pattern.No02Builder.product.Hamburger;

/**
 * Director
 * Builder 인터페이스를 사용하는 객체를 합성합니다.
 */
public class HamburgerStore {
    private HamburgerBuilder hamburgerBuilder;

    public void setHamburgerBuilder(HamburgerBuilder builder) {
        hamburgerBuilder = builder;
    }

    public void makeHamburger() {
        hamburgerBuilder.prepareNewHamburger();
        hamburgerBuilder.setHamburger();
    }

    public Hamburger getHamburger() {
        return hamburgerBuilder.createHamburger();
    }
}

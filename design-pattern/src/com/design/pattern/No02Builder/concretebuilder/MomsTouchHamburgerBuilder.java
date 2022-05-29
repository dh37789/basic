package src.com.design.pattern.No02Builder.concretebuilder;

import src.com.design.pattern.No02Builder.builder.HamburgerBuilder;
import src.com.design.pattern.No02Builder.product.Hamburger;

/**
 * ConcreteBuilder2
 * Builder 클래스에 정의된 인터페이스를 구현하며, 제품의 부품들을 모아 빌더를 복합합니다.
 * 생성한 요소의 표헌을 정의하고 관리합니다. 또한 제품을 검색하는 데 필요한 인터페이스를 제공합니다.
 */
public class MomsTouchHamburgerBuilder extends HamburgerBuilder {

    @Override
    public void setHamburger() {
        hamburger.setPatties(Hamburger.Patty.CHICKEN);
    }
}

package src.com.design.pattern.No02Builder;

import src.com.design.pattern.No02Builder.concretebuilder.BurgerKingHamburgerBuilder;
import src.com.design.pattern.No02Builder.concretebuilder.MomsTouchHamburgerBuilder;
import src.com.design.pattern.No02Builder.director.HamburgerStore;
import src.com.design.pattern.No02Builder.product.Hamburger;

public class Main {
    public static void main(String[] args) {
        HamburgerStore store = new HamburgerStore();
        MomsTouchHamburgerBuilder momsTouchBuilder = new MomsTouchHamburgerBuilder();
        BurgerKingHamburgerBuilder burgerKingBuilder = new BurgerKingHamburgerBuilder();

        /* 맘스터치 햄버거 생성 */
        store.setHamburgerBuilder(momsTouchBuilder);
        store.makeHamburger();
        Hamburger momsTouch = store.getHamburger();
        System.out.println("MomsTouch : " + momsTouch.toString());

        /* 버거킹 햄버거 생성 */
        store.setHamburgerBuilder(burgerKingBuilder);
        store.makeHamburger();
        Hamburger burgerKing = store.getHamburger();
        System.out.println("BurgerKing : " + burgerKing.toString());
    }
}

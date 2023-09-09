package com.design.pattern._01_creational_patterns._02_Builder;

import com.design.pattern._01_creational_patterns._02_Builder.concretebuilder.BurgerKingHamburgerBuilder;
import com.design.pattern._01_creational_patterns._02_Builder.concretebuilder.MomsTouchHamburgerBuilder;
import com.design.pattern._01_creational_patterns._02_Builder.director.HamburgerStore;
import com.design.pattern._01_creational_patterns._02_Builder.product.Hamburger;

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

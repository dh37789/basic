package com.design.pattern.No02Builder.product;

/**
 * Product
 * 생성할 복합 객체를 표현합니다.
 * ConcreteBuilder는 제품(Product)의 내부 표현을 구축하고 복합 객체가 어떻게 구성되는지에 관한 절차를 정의합니다.
 */
public class Hamburger {
    public enum Patty {NONE, BEEF, CHICKEN};

    public Patty patty = Patty.NONE;

    public void setPatties(Patty patty) {
        this.patty = patty;
    }

    @Override
    public String toString() {
        return "patty = " + patty;
    }
}

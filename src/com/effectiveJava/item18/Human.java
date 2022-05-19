package com.effectiveJava.item18;

/**
 * 부모 컴포지션 객체
 */
public class Human {
    Arm arm = new Arm();

    public String  stringToHuman() {
        return "나는 사람입니다. " + arm.stringToArm();
    }
}

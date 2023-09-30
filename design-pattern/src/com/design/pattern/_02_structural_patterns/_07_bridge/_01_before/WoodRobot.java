package com.design.pattern._02_structural_patterns._07_bridge._01_before;

public class WoodRobot implements Toy {

    @Override
    public void moveLeft() {
        System.out.println("wood robot move left");
    }

    @Override
    public void moveRight() {
        System.out.println("wood robot move right");
    }

    @Override
    public void moveForward() {
        System.out.println("wood robot move forward");
    }

    @Override
    public void moveBack() {
        System.out.println("wood robot move back");
    }
}

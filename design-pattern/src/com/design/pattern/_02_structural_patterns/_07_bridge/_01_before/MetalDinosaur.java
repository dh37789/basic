package com.design.pattern._02_structural_patterns._07_bridge._01_before;

public class MetalDinosaur implements Toy {
    @Override
    public void moveLeft() {
        System.out.println("metal dinosaur move left");
    }

    @Override
    public void moveRight() {
        System.out.println("metal dinosaur move right");
    }

    @Override
    public void moveForward() {
        System.out.println("metal dinosaur move forward");
    }

    @Override
    public void moveBack() {
        System.out.println("metal dinosaur move back");
    }
}

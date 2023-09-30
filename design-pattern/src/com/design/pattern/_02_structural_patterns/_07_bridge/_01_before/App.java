package com.design.pattern._02_structural_patterns._07_bridge._01_before;

public class App {

    public static void main(String[] args) {
        Toy metalRobot = new MetalRobot();
        metalRobot.moveLeft();
        metalRobot.moveForward();
    }
}

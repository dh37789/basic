package com.design.pattern._02_structural_patterns._07_bridge._02_after;

public class App {
    public static void main(String[] args) {
        Toy metalRobot = new Robot(new Metal());
        metalRobot.moveBack();
        metalRobot.moveLeft();

        Toy woodDinosaur = new Dinosaur(new Wood());
        woodDinosaur.moveLeft();
        woodDinosaur.moveRight();
    }
}

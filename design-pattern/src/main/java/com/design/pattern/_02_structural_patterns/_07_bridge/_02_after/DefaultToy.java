package com.design.pattern._02_structural_patterns._07_bridge._02_after;

public class DefaultToy implements Toy {
    private Texture texture;
    private String type;

    public DefaultToy(Texture texture, String type) {
        this.texture = texture;
        this.type = type;
    }

    @Override
    public void moveLeft() {
        System.out.printf("%s %s move left\n", texture.getTextureName(), this.type);
    }

    @Override
    public void moveRight() {
        System.out.printf("%s %s move right\n", texture.getTextureName(), this.type);
    }

    @Override
    public void moveForward() {
        System.out.printf("%s %s move forward\n", texture.getTextureName(), this.type);
    }

    @Override
    public void moveBack() {
        System.out.printf("%s %s move back\n", texture.getTextureName(), this.type);
    }
}

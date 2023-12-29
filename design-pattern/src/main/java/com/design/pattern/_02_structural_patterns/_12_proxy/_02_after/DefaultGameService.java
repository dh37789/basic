package com.design.pattern._02_structural_patterns._12_proxy._02_after;

public class DefaultGameService implements GameService{
    @Override
    public void startGame() {
        System.out.println("게임을 시작합니다.");
    }
}

package com.design.pattern._02_structural_patterns._12_proxy._02_after;

public class GameServiceProxy implements GameService{

    private GameService gameService;

    @Override
    public void startGame() {
        long before = System.currentTimeMillis();

        if (this.gameService == null)
            this.gameService = new DefaultGameService();

        // 권한 부여 등등..

        gameService.startGame();
        System.out.println(System.currentTimeMillis() - before);
    }
}

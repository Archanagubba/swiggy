package com.arena;

public class Main {
    public static void main(String[] args) {
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);

        Game game = new Game(playerA, playerB);
        game.start();
    }
}

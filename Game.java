package com.arena;

public class Game {
    private Player playerA;
    private Player playerB;
    private Dice dice;

    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = new Dice();
    }

    public void start() {
        System.out.println("Game Start!");
        Player attacker = (playerA.getHealth() <= playerB.getHealth()) ? playerA : playerB;
        Player defender = (attacker == playerA) ? playerB : playerA;

        while (attacker.isAlive() && defender.isAlive()) {
            executeTurn(attacker, defender);

            // Swap roles
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        Player winner = attacker.isAlive() ? attacker : defender;
        System.out.println("Player " + (winner == playerA ? "A" : "B") + " wins!");
    }

    private void executeTurn(Player attacker, Player defender) {
        int attackRoll = dice.roll();
        int defenseRoll = dice.roll();

        int attackDamage = attackRoll * attacker.getAttackValue();
        int defense = defenseRoll * defender.getStrengthValue();

        int damageToDefender = Math.max(0, attackDamage - defense);
        defender.reduceHealth(damageToDefender);

        System.out.println("Attacker rolled " + attackRoll + ", Defender rolled " + defenseRoll);
        System.out.println("Damage: " + damageToDefender + " to Defender. Defender's health is now " + defender.getHealth());
    }
}

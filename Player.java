package com.arena;

public class Player {
    private int health;
    private int strength;
    private int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public int getAttackValue() {
        return attack;
    }

    public int getStrengthValue() {
        return strength;
    }
    
    public boolean isAlive() {
        return this.health > 0;
    }
}

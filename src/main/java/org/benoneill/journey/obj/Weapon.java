package org.benoneill.journey.obj;

import org.benoneill.journey.world.World;

public abstract class Weapon extends Item {

    private int damage;

    public Weapon(String tag, String description, String[] shorthands, boolean usable, int value, int weight, int
                  damage) {
        super(tag, description, shorthands, usable, value, weight);
        this.damage = damage;
    }

    public abstract void attack(World w);

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

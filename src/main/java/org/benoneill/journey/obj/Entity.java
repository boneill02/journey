package org.benoneill.journey.obj;

import java.util.ArrayList;

public abstract class Entity extends Container {

    private String[] shorthands;
    private ArrayList<ClothingItem> clothes;
    private Weapon equippedWeapon;
    private int health;

    public Entity(String tag, String description, String[] shorthands, ArrayList<GameObject> objects) {
        super(tag, description, objects);
        this.shorthands = shorthands;
        clothes = new ArrayList<>();
    }

    public void addClothing(ClothingItem clothingItem) {
        clothes.add(clothingItem);
    }

    public void removeClothing(ClothingItem clothingItem) {
        clothes.remove(clothingItem);
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}

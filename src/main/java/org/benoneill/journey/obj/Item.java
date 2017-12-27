package org.benoneill.journey.obj;

public abstract class Item extends GameObject {

    private String[] shorthands;
    private boolean usable;
    private int value;
    private int weight;

    public Item(String tag, String description, String[] shorthands, boolean usable, int value, int weight) {
        super(tag, description);
        this.shorthands = shorthands;
        this.usable = usable;
        this.value = value;
        this.weight = weight;
    }

    public String[] getShorthands() {
        return shorthands;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public abstract void use();

}

package org.benoneill.journey.obj;

import java.util.ArrayList;

public class ClothingItem extends Container {

    private float maxWeight;
    private int value;

    public ClothingItem(String tag, String description, GameObject[] objects,
                        float maxWeight, int value) {
        super(tag, description, objects);
        this.maxWeight = maxWeight;
        this.value = value;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(float maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

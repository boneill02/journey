package org.benoneill.journey.obj;

import java.util.ArrayList;

public class Player extends Entity {

    private int gold;
    private int score;

    public Player(String tag, String description, String[] shorthands, ArrayList<GameObject> objects, int gold) {
        super(tag, description, shorthands, objects);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

package org.benoneill.journey.obj;

import org.benoneill.journey.world.World;

public abstract class Command extends GameObject {

    private String[] shorthands;

    public Command(String tag, String description, String[] shorthands) {
        super(tag, description);
        this.shorthands = shorthands;
    }

    public abstract void exec(World world, String args);

    public String[] getShorthands() {
        return shorthands;
    }

}

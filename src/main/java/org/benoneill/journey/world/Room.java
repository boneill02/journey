package org.benoneill.journey.world;

import org.benoneill.journey.obj.GameObject;
import org.benoneill.journey.obj.Container;
import org.benoneill.journey.obj.Entity;

import java.util.ArrayList;

public abstract class Room extends Container {

    private Entity[] entities;
    private boolean accessible;

    public Room(String tag, String description, GameObject[] objects, Entity[] entities,
                boolean accessible) {
        super(tag, description, objects);
        this.entities = entities;
    }

    public abstract void enter(World w);

    public abstract void leave(World w, Direction d);

    public Entity[] getEntities() {
        return entities;
    }

    public void setEntities(Entity[] entities) {
        this.entities = entities;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }
}

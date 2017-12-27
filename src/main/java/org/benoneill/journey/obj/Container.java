package org.benoneill.journey.obj;

import java.util.ArrayList;

public abstract class Container extends GameObject {

    private ArrayList<GameObject> objects;

    public Container(String tag, String description, ArrayList<GameObject> objects) {
        super(tag, description);
        this.objects = objects;
    }

    public boolean hasObject(GameObject obj) {
        if(objects.contains(obj)) {
            return true;
        }
        return false;
    }

    public ArrayList<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<GameObject> objects) {
        this.objects = objects;
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

}

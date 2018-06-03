package org.benoneill.journey.obj;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Container extends GameObject {

    private ArrayList<GameObject> objects;

    public Container(String tag, String description, GameObject[] objects) {
        super(tag, description);
        this.objects = new ArrayList<GameObject>(Arrays.asList(objects));
    }

    public boolean hasObject(GameObject obj) {
        if(objects.contains(obj)) {
            return true;
        }
        return false;
    }

    public GameObject[] getObjects() {
        GameObject[] arr = new GameObject[objects.size()];
        arr = objects.toArray(arr);
        return arr;
    }

    public void setObjects(GameObject[] objects) {
        this.objects = new ArrayList<GameObject>(Arrays.asList(objects));
    }

    public void addObject(GameObject object) {
        objects.add(object);
    }

    public void removeObject(GameObject object) {
        objects.remove(object);
    }

}

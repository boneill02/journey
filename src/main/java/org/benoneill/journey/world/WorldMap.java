package org.benoneill.journey.world;

import java.util.*;

public class WorldMap {

    Map<Integer, Map<Integer, Room>> rooms;

    public WorldMap() {
        rooms = new HashMap<>();
    }

    public void addRoom(Room r, int x, int y) {
        if (rooms.containsKey(x)) {
            rooms.get(x).put(y, r);
        } else {
            rooms.put(x, new HashMap<Integer, Room>());
        }
    }

    public Room getRoom(int x, int y) {
        return rooms.get(x).get(y);
    }

    public boolean canGo(int x, int y) {
        if(rooms.containsKey(x)) {
            if(rooms.get(x).containsKey(y)) {
                return true;
            }
        }
        return false;
    }

}

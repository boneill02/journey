package org.benoneill.journey.world;

import org.benoneill.journey.obj.Command;
import org.benoneill.journey.obj.Entity;
import org.benoneill.journey.obj.Item;
import org.benoneill.journey.obj.Player;

import java.util.Scanner;

public class World {

    private WorldMap map;
    private WorldMap[] maps;
    private Room room;
    private boolean running;
    private Command[] commands;
    private Entity[] entities;
    private Item[] items;
    private Player player;
    private int x, y;
    private String cmdPrefix;

    public World(String cmdPrefix, WorldMap[] maps,
                 Room startRoom, Command[] commands, Item[] items, Entity[] entities, Player player) {
        this.cmdPrefix = cmdPrefix;
        this.room = startRoom;
        this.maps = maps;
        this.commands = commands;
        this.items = items;
        this.entities = entities;
        this.player = player;
        running = false;
        x = 0;
        y = 0;
    }

    public void start() {
        running = true;
        while(running) {
            parse();
        }
    }

    private void parse() {
        System.out.print(cmdPrefix);
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim().toLowerCase();
        for(Command c : commands) {
            for(String s : c.getShorthands()) {
                if(input.startsWith(s + " ")) {
                    c.exec(this, input.substring(s.length()).trim());
                    return;
                } else if(input.equals(s)) {
                    c.exec(this, "");
                    return;
                }
            }
        }
        System.out.println("Invalid input!");
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public WorldMap getMap() {
        return map;
    }

    public void setMap(WorldMap map) {
        this.map = map;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Command[] getCommands() {
        return commands;
    }

    public Item[] getItems() {
        return items;
    }

    public int getX() {
        return x;
    }

    public void setX() {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}

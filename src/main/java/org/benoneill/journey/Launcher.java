package org.benoneill.journey;

import org.benoneill.journey.world.World;
import org.benoneill.journey.world.WorldLoader;

import javax.script.ScriptException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("Choose a world:");
        boolean parsed = false;
        String worldName = "";

        File worldDirectory = new File("worlds");

        String[] worldTitles = new String[worldDirectory.list().length];

        for(int i = 0; i < worldTitles.length; i++) {
            try {
                worldTitles[i] = WorldLoader.getWorldInfo(worldDirectory.listFiles()[i]).getTitle();
            } catch (FileNotFoundException e) {
                System.out.println("Error caught while reading world files.");
                e.printStackTrace();
                System.exit(1);
            }
        }

        while(!parsed) {

            for(int i = 0; i < worldTitles.length; i++) {
                System.out.println((i + 1) + ": " + worldTitles[i]);
            }

            System.out.print("> ");

            Scanner sc = new Scanner(System.in);



            try {
                int num = Integer.parseInt(sc.nextLine()) - 1;
                if(num < worldDirectory.listFiles().length) {
                    worldName = worldDirectory.listFiles()[num].getName();
                    parsed = true;
                }
            } catch(Exception e) {
                System.out.println("Couldn't get a valid number from your input.");
            }
        }

        World w = null;
        try {
            System.out.println(worldName);
            w = WorldLoader.loadWorld(new File("worlds/" + worldName + "/js"));
        } catch (Exception e) {
            System.out.println("Error caught while reading world files.");
            e.printStackTrace();
            System.exit(1);
        }
        w.start();
    }

}

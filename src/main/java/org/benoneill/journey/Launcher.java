package org.benoneill.journey;

import org.benoneill.journey.world.World;
import org.benoneill.journey.world.WorldLoader;

import javax.script.ScriptException;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Launcher {

    public void worldPrompt() {
        boolean parsed = false;
        String worldName = "";

        File worldDirectory = new File("worlds");
        String[] worldTitles = null;
        int chosenWorld = 0;

        if(worldDirectory.exists() && worldDirectory.isDirectory()) {
            worldTitles = new String[worldDirectory.list().length];
        } else {
            worldDirectory.mkdir();
            System.out.println("No worlds found in worlds directory.");
            return;
        }

        System.out.println("Choose a world:");

        for(int i = 0; i < worldTitles.length; i++) {
            try {
                worldTitles[i] = WorldLoader.getWorldInfo(worldDirectory.listFiles()[i]).getTitle();
            } catch (FileNotFoundException e) {
                System.out.println("Error caught while reading world files.");
                System.out.println(e.getCause());
                System.exit(1);
            } catch (JAXBException e) {
                System.out.println("Error caught while parsing XML");
                System.out.println(e.getCause());
            }
        }

        while(!parsed) {

            for(int i = 0; i < worldTitles.length; i++) {
                System.out.println((i + 1) + ": " + worldTitles[i]);
            }

            System.out.print("> ");

            Scanner sc = new Scanner(System.in);



            try {
                chosenWorld = Integer.parseInt(sc.nextLine()) - 1;
                if(chosenWorld < worldDirectory.listFiles().length) {
                    worldName = worldDirectory.listFiles()[chosenWorld].getName();
                    parsed = true;
                }
            } catch(Exception e) {
                System.out.println("Couldn't get a valid number from your input.");
            }
        }

        World w = null;
        try {
            w = WorldLoader.loadWorld(new File("worlds/" + worldName + "/js"));
            System.out.println(worldTitles[chosenWorld] + " loaded.");
        } catch (ScriptException e) {
            System.out.println("Error caught while reading world files.");
            System.out.println("More info:");
            System.out.println("File name: " +  e.getFileName());
            System.out.println("Line number: " +  e.getLineNumber());
            System.out.println("Column number: " + e.getColumnNumber());
            System.out.println("Interpreter Message:");
            System.out.println(e.getMessage());
            System.exit(1);
        } catch (FileNotFoundException e) {
            System.out.println("A necessary file could not be found!");
            System.out.println("More info:");
            System.out.println(e.getMessage());
        }
        w.start();
    }

    public static void main(String[] args) {
        Launcher launcher = new Launcher();
        launcher.worldPrompt();
    }

}

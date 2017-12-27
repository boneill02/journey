package org.benoneill.journey.world;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.google.gson.Gson;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

public class WorldLoader {

    public static WorldInfo getWorldInfo(File dir) throws FileNotFoundException {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(new BufferedReader(new FileReader(new File(dir.getAbsolutePath() + "/worldinfo.json"))), new TypeToken<WorldInfo>(){}.getType());
    }

    public static World loadWorld(File gameJSDir) throws ScriptException, FileNotFoundException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("var ClothingItem = Java.extend(Java.type(\"org.benoneill.journey.obj.ClothingItem\"))");
        engine.eval("var Entity = Java.extend(Java.type(\"org.benoneill.journey.obj.Entity\"))");
        engine.eval("var Weapon = Java.extend(Java.type(\"org.benoneill.journey.obj.Weapon\"))");
        engine.eval("var Command = Java.extend(Java.type(\"org.benoneill.journey.obj.Command\"))");
        engine.eval("var Item = Java.extend(Java.type(\"org.benoneill.journey.obj.Item\"))");
        engine.eval("var Player = Java.extend(Java.type(\"org.benoneill.journey.obj.Player\"))");
        engine.eval("var World = Java.extend(Java.type(\"org.benoneill.journey.world.World\"))");
        engine.eval("var WorldMap = Java.extend(Java.type(\"org.benoneill.journey.world.WorldMap\"))");
        engine.eval("var Room = Java.extend(Java.type(\"org.benoneill.journey.world.Room\"))");
        engine.eval("var getln = function(s) { return new Java.type(\"java.io.Scanner\", Java.type(\"System.in\")).nextLine(); };");

        File[] files = gameJSDir.listFiles();
        for(File f : files) {
            for(String s : WorldLoader.getWorldInfo(gameJSDir.getParentFile()).getLoadOrder()) {
                if(f.getName().equals(s)) {
                    engine.eval(new FileReader(f));
                }
            }
        }

        World world = (World) engine.eval("world");

        return world;
    }

}

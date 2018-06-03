package org.benoneill.journey.world;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class WorldLoader {

    public static WorldInfo getWorldInfo(File dir) throws FileNotFoundException, JAXBException {
        WorldInfo info = new WorldInfo();

        File infoFile = new File(dir.getAbsolutePath() + "/worldinfo.xml");

        if(infoFile.exists()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(WorldInfo.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            info = (WorldInfo) unmarshaller.unmarshal(new File(dir + "/worldinfo.xml"));
            return info;
        }

        return null;
    }

    public static World loadWorld(File gameJSDir) throws ScriptException, FileNotFoundException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.eval("var ArrayList = Java.type(\"java.util.ArrayList\")");
        engine.eval("var ClothingItem = Java.type(\"org.benoneill.journey.obj.ClothingItem\")");
        engine.eval("var Entity = Java.type(\"org.benoneill.journey.obj.Entity\")");
        engine.eval("var Weapon = Java.type(\"org.benoneill.journey.obj.Weapon\")");
        engine.eval("var Command = Java.type(\"org.benoneill.journey.obj.Command\")");
        engine.eval("var Item = Java.type(\"org.benoneill.journey.obj.Item\")");
        engine.eval("var World = Java.type(\"org.benoneill.journey.world.World\")");
        engine.eval("var WorldMap = Java.type(\"org.benoneill.journey.world.WorldMap\")");
        engine.eval("var Room = Java.type(\"org.benoneill.journey.world.Room\")");
        engine.eval("var scanner = Java.type(\"java.util.Scanner\", Java.type(\"java.lang.System\").in);");
        engine.eval("var readln = function() { return scanner.nextLine(); };");
        engine.eval("var println = function(s) { Java.type(\"java.lang.System\").out.println(s); };");

        engine.eval(new FileReader(gameJSDir.getAbsolutePath() + "/world.js"));

        World world = (World) engine.eval("world");

        return world;
    }

}

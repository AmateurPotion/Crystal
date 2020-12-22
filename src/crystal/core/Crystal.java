package crystal.core;

import arc.*;
import arc.util.*;

import mindustry.game.EventType.*;
import mindustry.mod.*;

import crystal.io.*;
import crystal.content.ContentsLoader;
import crystal.ui.*;

import static crystal.Vars.*;

@SuppressWarnings("unused")
public class Crystal extends Mod {
    public Crystal(){
        Log.info("[royal]Crystal edition[] constructor loaded.");

        Events.on(ClientLoadEvent.class, e -> {
            new Initializer().init();
            new CustomUiList().init();
            new ContentsLoader().load();
            if (debugMode) {
                Log.info("client load");
            }
        });



        Events.on(WorldLoadEvent.class, e -> {
            if (debugMode) {
                Log.info("world load");
            }
        });
    }

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
        Log.info("Initializing Crystal content...");
    }
}
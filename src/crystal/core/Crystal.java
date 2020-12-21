package crystal.core;

import arc.*;
import arc.util.*;

import mindustry.game.EventType.*;
import mindustry.mod.*;

@SuppressWarnings("unused") // mod entry point
public class Crystal extends Mod{
    public Crystal(){
        Events.on(ClientLoadEvent.class, e -> {
            Log.info("client load");
        });

        Events.on(WorldLoadEvent.class, e -> {
            Log.info("world load");
        });
    }

    @Override
    public void init(){}

    @Override
    public void loadContent(){}
}

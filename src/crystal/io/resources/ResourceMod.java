package crystal.io.resources;

import arc.files.Fi;
import crystal.io.FileManager;

import static mindustry.Vars.*;

public class ResourceMod {
    private final FileManager fileManager = new FileManager();
    private final String rmName = "crystal-resource-mod";

    public void init(){
        fileManager.mkdir(new Fi(modDirectory.toString() + "/" + rmName));
        fileManager.mkdir(new Fi(modDirectory.toString() + "/" + rmName + "/"));
    }
}

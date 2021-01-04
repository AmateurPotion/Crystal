package crystal;

import arc.files.*;
import arc.assets.*;

import static mindustry.Vars.*;

public class Vars {
    /** crystal edition main data directory **/
    public static Fi mainDirectory = new Fi(modDirectory.toString() + "/Crystal");
    /** Debug mode. **/
    public static Boolean debugMode = true;
    /** Internet connection **/
    public static Boolean onlineMode = true;
    /** Root path for github Database **/
    public static String databaseRoot = "https://raw.githubusercontent.com/AmateurPotion/Crystal/main/SimpleDatabase/";
    /** public mod assets **/
    public static AssetManager modAssets;
}
package crystal.io;

import arc.Core;
import arc.Net;
import arc.files.Fi;
import arc.util.Log;
import arc.util.Strings;
import arc.util.serialization.Jval;

import java.util.concurrent.atomic.AtomicReference;

import static mindustry.Vars.*;
import static crystal.Vars.*;

public class GithubDatabase {
    private static Jval tempJval = null;

    public static Jval getDatabase(String gitPath){
        Core.net.httpGet("https://raw.githubusercontent.com/AmateurPotion/Crystal/main/SimpleDatabase/DatabaseInfo.json", res -> {
            if(res.getStatus() == Net.HttpStatus.OK){
                tempJval = Jval.read(res.getResultAsString());
                Log.info(res.getResultAsString());
            }
        }, error -> {});

        Log.info("test");
        return tempJval;
    }

    /** 모드 진입 후 네트워크 체크한 뒤에 한번만 초기화해도 충분함. 자주해서 렉걸려도 책임안짐 ㅅㄱ
     * 네트워크 체크 안 하고 이거 쓰면 게임 팅길 확률이 매우 높으니 주의! **/
    public void init(){
        getDatabase("Database.json");
        //Jval jval = getDatabase("DatabaseInfo.json");
        //int version = Strings.parseInt(jval.getString("version", "1"));
        //Jval temp = Jval.read(jval.getString("settings-version" + version));
        //databaseRoot = temp.getString("root", "https://raw.githubusercontent.com/AmateurPotion/Crystal/main/SimpleDatabase/Pre-release-1/");
    }

    public String getText(String gitPath){
        final String[] result = new String[1];

        Core.net.httpGet(databaseRoot + gitPath, res -> {
            if(res.getStatus() == Net.HttpStatus.OK){
                result[0] = res.getResultAsString();
            }
        }, error -> {});

        return result[0];
    }

    public void downloadFile(String gitPath, Fi downloadPath, Boolean waitAble){

    }

    public class GDatabase {
        private final Jval database;

        public GDatabase(Jval database){
            this.database = database;
        }

        public GDatabase(String databasePath){
            database = getDatabase(databasePath);
        }

        public Object[] getData(String key){
            Object[] result = new Object[]{};
            return result;
        }
    }
}

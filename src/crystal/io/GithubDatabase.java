package crystal.io;

import arc.Core;
import arc.Net;
import arc.Net.*;
import arc.files.Fi;
import arc.util.Log;
import arc.util.serialization.Jval;

import static crystal.Vars.*;
import static mindustry.Vars.*;

public class GithubDatabase {
    private static volatile String tempString;

    public Jval getDatabase(String gitPath){
        Jval jval;

        if(onlineMode){
            ui.loadfrag.show("@database.process");
            synchronized(this) {
                Core.net.httpGet(databaseRoot + gitPath, res -> {
                    if (res.getStatus() == Net.HttpStatus.OK) {
                        tempString = res.getResultAsString();
                    }} , error -> {});

                /** wait for web data receive **/
                while (tempString == null) {}
                if(tempString != null){
                    ui.loadfrag.hide();
                }
            }
        }
        if(!tempString.equals("404: Not Found")) {
            jval = Jval.read(tempString);
        } else {
            jval = Jval.read("{ }");
            jval.add("error", "404");
        }

        tempString = null;

        return jval;
    }

    /** 모드 진입 후 네트워크 체크한 뒤에 한번만 초기화해도 충분함. 자주해서 렉걸려도 책임안짐 ㅅㄱ
     * 네트워크 체크 안 하고 이거 쓰면 게임 팅길 확률이 매우 높으니 주의! **/
    public void init(){
        Jval jval = getDatabase("DatabaseInfo.json");
        String version = jval.getString("version", "1");
        Jval temp = jval.get("settings-version" + version);
        databaseRoot = temp.getString("root", "https://raw.githubusercontent.com/AmateurPotion/Crystal/main/SimpleDatabase/Pre-release-1/");
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

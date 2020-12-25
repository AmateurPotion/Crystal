package crystal.io;

import arc.Core;
import arc.Net;
import arc.files.Fi;
import arc.util.serialization.Jval;

import static crystal.Vars.*;

public class GithubDatabase {
    public Jval getDatabase(String path){
        final Jval[] jval = new Jval[1];

        Core.net.httpGet(path, res -> {
            if(res.getStatus() == Net.HttpStatus.OK){
                jval[0] = Jval.read(res.getResultAsString());
            }
        }, error -> {});

        return jval[0];
    }

    /** 모드 진입 후 네트워크 체크한 뒤에 한번만 초기화해도 충분함. 자주해서 렉걸려도 책임안짐 ㅅㄱ
     * 네트워크 체크 안 하고 이거 쓰면 게임 팅길 확률이 매우 높으니 주의! **/
    public void init(){
        Jval jval = getDatabase(databaseRoot + "DatabaseInfo.json");
        databaseRoot = jval.getString("settings-version" + jval.getString("version","1"), "https://raw.githubusercontent.com/AmateurPotion/Crystal/main/SimpleDatabase/Pre-release-1/");
    }

    public String getText(String path){
        final String[] result = new String[1];

        Core.net.httpGet(path, res -> {
            if(res.getStatus() == Net.HttpStatus.OK){
                result[0] = res.getResultAsString();
            }
        }, error -> {});

        return result[0];
    }

    public void downloadFile(String path, Fi where, Boolean waitAble){

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

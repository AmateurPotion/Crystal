package crystal.io;

import arc.Core;
import arc.Net;
import arc.util.serialization.Jval;

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

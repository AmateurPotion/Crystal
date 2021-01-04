package crystal.io;

import arc.files.Fi;

public class FileManager {
    public boolean mkdir(Fi directoryPath){
        if(directoryPath.isDirectory()) {
            return true;
        } else if(directoryPath.exists()) {
            return false;
        } else {
            directoryPath.mkdirs();
            return true;
        }
    }
}

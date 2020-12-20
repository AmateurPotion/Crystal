package crystal.io;

import arc.files.*;
import arc.util.*;

import mindustry.ui.dialogs.BaseDialog;

import java.net.InetSocketAddress;
import java.net.Socket;

import crystal.ui.window.TestWindow;

import static mindustry.Vars.*;
import static crystal.Vars.*;

public class Initializer {

    public Initializer(){}

    public void init() {
        onlineMode = netConnection();

        if(debugMode) {
            new TestWindow().draw();
        }

        Fi tempFi;
        tempFi = new Fi(modDirectory.toString() + "/Crystal/data");
        if (!tempFi.exists()) {
            tempFi.mkdirs();
            mainDirectory = new Fi(modDirectory.toString() + "/Crystal");
        }

        if (new Fi(modDirectory.toString() + "/Crystal/data/settings.bin").exists()) {

        }else{
            if (onlineMode) {
                BaseDialog dialog = new BaseDialog("@data.settings");
                dialog.cont.add("@data.settings.updatequestion").row();
                dialog.cont.button("@yes", this::installData).size(50f, 50f);
                dialog.cont.button("@no", dialog::hide).size(100f, 50f);
                dialog.show();
            } else {
                BaseDialog dialog = new BaseDialog("@data.settings");
                dialog.cont.add("@data.settings.noconnection").row();
                dialog.cont.button("@ok", dialog::hide).size(100f, 50f);
                dialog.show();
            }
        }
    }
    private boolean netConnection(){
        boolean connected = true;
        Socket socket = new Socket();
        InetSocketAddress tempISA = new InetSocketAddress("www.google.com", 80);

        try{
            socket.connect(tempISA, 3000);
            socket.close();
        } catch (Exception e){
            connected = false;
        }
        return connected;
    }

    private void installData(){

    }
}

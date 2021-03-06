package crystal.io;

import java.net.InetSocketAddress;
import java.net.Socket;

import arc.Core;
import arc.files.*;
import arc.util.*;
import arc.util.serialization.Jval;

import mindustry.ui.dialogs.BaseDialog;

import crystal.ui.window.TestWindow;
import crystal.io.resources.ResourceMod;

import static mindustry.Vars.*;
import static crystal.Vars.*;

public class Initializer {
    private final FileManager fileManager = new FileManager();

    public Initializer() {
    }

    public void init() {
        Fi tempFi;
        GithubDatabase githubDatabase = new GithubDatabase();
        onlineMode = netConnection();

        if (onlineMode) {
            githubDatabase.init();
            Jval.JsonArray ja = githubDatabase.getDatabase("Info.json").get("notice").asArray();

            for (int i = 0; i < ja.size; i++) {
                Log.info(ja.get(i));
            }
        }

        Log.info(Core.settings.getString("locale"));

        if (debugMode && !android && !steam) {
            new TestWindow().draw();
        }

        fileManager.mkdir(new Fi(modDirectory.toString() + "/Crystal/data"));

        if (new Fi(modDirectory.toString() + "/Crystal/data/settings.bin").exists()) {

        } else {
            if (onlineMode) {
                BaseDialog dialog = new BaseDialog("@data.settings");
                float X = dialog.getWidth(), Y = dialog.getHeight();
                dialog.cont.add("@data.settings.updatequestion").row();
                dialog.cont.button("@yes", this::installData)
                        .size(80f, 50f);
                dialog.cont.button("@no", dialog::hide)
                        .size(80f, 50f);
                dialog.show();
            } else {
                BaseDialog dialog = new BaseDialog("@data.settings");
                dialog.cont.add("@data.settings.noconnection").row();
                dialog.cont.button("@ok", dialog::hide).size(100f, 50f);
                dialog.show();
            }
        }
    }


    private boolean netConnection() {
        boolean connected = true;
        Socket socket = new Socket();
        InetSocketAddress tempISA = new InetSocketAddress("www.google.com", 80);

        try {
            socket.connect(tempISA, 3000);
            socket.close();
        } catch (Exception e) {
            connected = false;
        }
        return connected;
    }

    private void installData() {
    }
}

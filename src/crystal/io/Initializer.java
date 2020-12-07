package crystal.io;

import arc.files.*;
import mindustry.ui.dialogs.BaseDialog;

import static mindustry.Vars.*;
import static crystal.Vars.*;

public class Initializer {
    private Fi tempFi;

    public Initializer(){}

    public void init(){
        tempFi = new Fi(modDirectory.toString() + "/Crystal/data");
        if (!tempFi.exists()) {
            tempFi.mkdirs();
            mainDirectory = new Fi(modDirectory.toString() + "/Crystal");
        }

        tempFi = new Fi(modDirectory.toString() + "/Crystal/data/settings.bin");
        if (tempFi.exists()) {

        }else{
            if (true) {
                BaseDialog dialog = new BaseDialog("@data.settings");
                dialog.cont.add("@data.settings.question").row();
                dialog.cont.button("@yes", this::installData).size(50f, 50f);
                dialog.cont.button("@no", dialog::hide).size(100f, 50f);
                dialog.show();
            } else {
                mainServerConnected = false;
                BaseDialog dialog = new BaseDialog("@data.settings");
                dialog.cont.add("@data.settings.noloaded").row();
                dialog.cont.button("@ok", dialog::hide).size(100f, 50f);
                dialog.show();
            }
        }
    }

    private void installData(){

    }
}

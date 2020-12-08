package crystal.io;

import arc.files.*;
import arc.util.*;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import mindustry.ui.dialogs.BaseDialog;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static mindustry.Vars.*;
import static crystal.Vars.*;

public class Initializer {
    private Fi tempFi;

    public Initializer(){}

    public void init() throws ExecutionException, InterruptedException {
        Log.info("Start init");
        new DatabaseSetup().init();
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
        firebaseDBFirestore.collection("Crystal").addSnapshotListener( (target, exception)->{
            Log.info(" - select start - ");
            if (target != null) {
                target.forEach( item->{
                    Log.info("primary id : "+item.getId() + "  ||  value : " + item.getData());
                });
            }
            Log.info(" - select end - ");
        });
        Log.info("init end");

    }

    private void installData(){

    }
}

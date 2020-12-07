package crystal.ui.dialog;

import arc.*;
import arc.util.*;

//import mindustry.ui.*;
import mindustry.ui.dialogs.BaseDialog;

public class TestDialog extends BaseDialog {
    public TestDialog(){
        super("@crystal.testdialog");

        setup();
        shown(this::setup);
    }

    private void setup() {
        cont.clear();
        
        Time.runTask(10f, () -> {
            BaseDialog dialog = new BaseDialog("frog");
            dialog.cont.add("behold").row();
            dialog.cont.image(Core.atlas.find("example-java-mod-frog")).pad(20f).row();
            dialog.cont.button("I see", dialog::hide).size(100f, 50f);
            dialog.show();
        });
    }
}

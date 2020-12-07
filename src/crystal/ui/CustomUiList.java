package crystal.ui;

import arc.ApplicationListener;
import arc.assets.Loadable;
import crystal.ui.dialog.*;
import crystal.ui.fragment.*;

import mindustry.Vars;

public class CustomUiList implements ApplicationListener, Loadable {
    // fragment
    public static CMenuFrag cMenuFrag;
    // dialog
    public static LauncherDialog launcher;
    public static ResourceHubDialog rhub;

    public void init() {
        // fragment
        cMenuFrag = new CMenuFrag();
        // dialog
        launcher = new LauncherDialog();
        rhub = new ResourceHubDialog();

        // build
        cMenuFrag.build(Vars.ui.menuGroup);
    }
}

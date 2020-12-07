package crystal.ui.dialog;

import arc.scene.ui.ScrollPane;
import arc.scene.ui.layout.Table;
import mindustry.ui.dialogs.BaseDialog;

public class ResourceHubDialog extends BaseDialog {
    public ResourceHubDialog() {
        super("@crystal.resourcehub");

        setup();

        shown(this::setup);
    }
    private void setup() {
        cont.clear();

        Table table = new Table();
        ScrollPane pane = new ScrollPane(table);
        pane.setFadeScrollBars(false);

        cont.add(pane);
    }
}

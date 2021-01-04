package crystal.ui.dialog;

import arc.Core;
import arc.files.Fi;
import arc.graphics.Color;
import arc.graphics.g2d.TextureAtlas;
import arc.graphics.g2d.TextureRegion;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;

import mindustry.ui.Styles;
import mindustry.ui.dialogs.BaseDialog;

import crystal.ui.CustomUiList;

import java.io.FileWriter;

import static arc.Core.atlas;
import static mindustry.Vars.*;

public class LauncherDialog extends BaseDialog {
    public LauncherDialog(){
        super("@crystal.launcher");

        addCloseButton();

        if(android){
            setupMobile();
        }
        else{
            setupDesktop();
        }
    }

    public void refresh(){
        this.hide();
        CustomUiList.launcher.show();
    }

    private void setupDesktop(){
        cont.clear();

        Table table = new Table();
        ScrollPane pane = new ScrollPane(table);
        pane.setFadeScrollBars(false);

        final TextureRegion[] assetIcon = { Core.atlas.find("router"), atlas.find("junction") };
        Button b = new Button(Styles.logict);
        b.left();
        Image im = b.add(new Image(Core.atlas.find("router"))).size(30).pad(5).get();

        b.label(() -> (b.isOver() ? "[pink]" : "") + "$crystal.ui.asset" + "[]").pad(5);
        b.update(() -> {
                im.setDrawable(assetIcon[b.isOver() ? 1 : 0]);
                b.setColor(b.isOver() ? Color.pink : Color.white);
        });
        table.add(b).size(230, 60);

        cont.add(pane);
    }

    // Mobile is not supported yet.
    private void setupMobile(){
        cont.clear();

        Table table = new Table();
        ScrollPane pane = new ScrollPane(table);
        pane.setFadeScrollBars(false);

        table.add("String.valueOf(new Random().nextInt(10))");

        cont.add(pane);
    }
}

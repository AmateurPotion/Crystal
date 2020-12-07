package crystal.content;

import mindustry.content.TechTree;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.*;

public class TechTreeParser implements ContentList {
    private static TechNode context;

    @Override
    public void load(){

    }

    private static void attachNode(UnlockableContent parent, Runnable children){
        TechNode techNode = TechTree.all.find(t -> t.content == parent);
        context = techNode;
        children.run();
    }
}
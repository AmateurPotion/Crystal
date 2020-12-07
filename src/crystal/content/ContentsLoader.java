package crystal.content;

import mindustry.ctype.*;

public class ContentsLoader implements ContentList {
    public void load() {
        new MBlocks().load();
        new MItems().load();
        new TechTreeParser().load();
    }
}

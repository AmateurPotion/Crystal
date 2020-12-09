package crystal.content;

import mindustry.ctype.*;

import crystal.content.overwrite.ContentsOverwriter;

public class ContentsLoader implements ContentList {
    public void load() {
        new ContentsOverwriter().load();

        new MBlocks().load();
        new MItems().load();
        new TechTreeParser().load();
    }
}

package crystal.content;

import mindustry.ctype.*;

import crystal.content.overwrite.ContentsOverwriter;

public class ContentsLoader implements ContentList {
    private final ContentList[] contents = {
            new Artifacts(),
            new MBlocks(),
            new MItems(),
            new TechTreeParser(),
            new ContentsOverwriter(),
    };
    public void load() {
            for(ContentList list : contents){
                list.load();
            }
    }
}

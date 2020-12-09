package crystal.content.overwrite;

import mindustry.ctype.ContentList;

public class ContentsOverwriter implements ContentList {
    @Override
    public void load(){
        new BlockOverwrite().load();
    }
}

package crystal.tech;

import arc.graphics.Color;
import mindustry.ctype.ContentType;
import mindustry.ctype.UnlockableContent;

public class Artifact extends UnlockableContent {
    public boolean update;

    public Artifact(String name){
        super(name);
    }

    public void active(){

    }
    @Override
    public ContentType getContentType(){

        return ContentType.typeid_UNUSED;
    }
}

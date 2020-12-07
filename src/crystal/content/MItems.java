package crystal.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class MItems implements ContentList {
    public static Item testitem;

    @Override
    public void load() {
        testitem = new Item("testitem", Color.valueOf("d99d73")){{
            cost = 1;
        }};
    }
}

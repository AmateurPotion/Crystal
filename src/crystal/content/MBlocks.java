package crystal.content;

import mindustry.ctype.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.content.*;

import static mindustry.type.ItemStack.*;

public class MBlocks implements ContentList {
    public static Block test;

    @Override
    public void load() {
        int wallHealthMultiplier = 4;

        test = new Wall("testwall"){{
            requirements(Category.defense, with(Items.copper, 6));
            health = 80 * wallHealthMultiplier;
        }};
    }
}

package crystal.content;

import mindustry.content.Items;
import mindustry.ctype.*;
import mindustry.type.Category;
import mindustry.world.*;

import crystal.world.blocks.artifact.*;
import crystal.world.module.*;

import static mindustry.type.ItemStack.*;

public class MBlocks implements ContentList {
    public static Block charger, testBlock;

    @Override
    public void load() {
        charger = new ArtifactActivator("charger"){{
            requirements(Category.effect, with(MItems.coreResource, 1, Items.copper, 1000, Items.lead, 500));
            hasLiquids = true;
            liquidCapacity = 100f;
            size = 1;
        }};

        testBlock = new TestBlock("test-block"){{

        }};
    }
}

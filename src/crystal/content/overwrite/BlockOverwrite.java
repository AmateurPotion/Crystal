package crystal.content.overwrite;

import arc.func.Cons;
import arc.func.Prov;

import mindustry.ctype.*;
import mindustry.content.*;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.campaign.Accelerator;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.meta.BuildVisibility;

import crystal.content.MItems;

import static mindustry.type.ItemStack.*;

public class BlockOverwrite extends Blocks implements ContentList {
    private static final Prov<Block[]> hideArray = () -> new Block[]{
            melter, interplanetaryAccelerator
    };

    @SuppressWarnings("unchecked")
    public <T extends UnlockableContent> void OverWrite(UnlockableContent target, Cons<T> setter){
        setter.get((T) target);
    }

    @Override
    public void load(){
        for(Block block : hideArray.get()) { block.buildVisibility = BuildVisibility.sandboxOnly; }

        OverWrite(interplanetaryAccelerator, (Accelerator t) -> {
            t.alwaysUnlocked = true;
            t.requirements(Category.effect, BuildVisibility.campaignOnly, with(Items.copper, 1));
        });
        /* OverWrite(melter, (GenericCrafter t) -> {
            t.buildCost = 1;
            t.requirements = with(Items.copper, 10);
        }); */
    }
}

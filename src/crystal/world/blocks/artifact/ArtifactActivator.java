package crystal.world.blocks.artifact;

import arc.graphics.g2d.TextureRegion;

import mindustry.annotations.Annotations.*;
import mindustry.world.Block;
import mindustry.world.meta.BlockGroup;

public class ArtifactActivator extends Block {
    public @Load("@-on") TextureRegion onRegion;

    public ArtifactActivator(String name) {
        super(name);

        group = BlockGroup.projectors;
        hasItems = false;
        solid = true;
        configurable = true;
        update = true;
        autoResetEnabled = false;

    }
}

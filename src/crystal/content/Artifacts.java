package crystal.content;

import mindustry.ctype.ContentList;

import crystal.tech.Artifact;
import crystal.tech.artifacts.*;

public class Artifacts implements ContentList {
    public static Artifact routerTech;

    @Override
    public void load(){
        routerTech = new RouterTech("router-tech"){{

        }};
    }
}

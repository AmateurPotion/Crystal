package crystal

import arc.*
import arc.util.*

import mindustry.mod.*;
import mindustry.game.EventType.*

@Suppress("unused")
class Main : Mod() {
    init {
    Events.on(ClientLoadEvent::class.java) { e: ClientLoadEvent ->
        // client load
        }

    Events.on(WorldLoadEvent::class.java) { e: WorldLoadEvent ->
        // world load
        }
    }

    override fun init() {
    }

    override fun loadContent() {
        Log.info("Loading Crystal edition content..")
    }
}
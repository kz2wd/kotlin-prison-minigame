package com.cludivers.kz2wdprison.gameplay.world.mines

import com.cludivers.kz2wdprison.gameplay.player.isInArea
import com.cludivers.kz2wdprison.gameplay.world.cuboid.BlockPattern
import com.cludivers.kz2wdprison.gameplay.world.cuboid.Cuboid
import org.bukkit.Bukkit
import org.bukkit.Location

class PrisonMine(val name: String,
    private val miningArea: Cuboid, private val pattern: BlockPattern,
                 private val mineEntry: Location, val respawnTimeInTick: Int) {

    fun reset(){
        Bukkit.getOnlinePlayers().forEach {
            if (it.isInArea(miningArea)){
                it.teleport(mineEntry)
            }
        }

        miningArea.fillWithPattern(pattern)

    }
}
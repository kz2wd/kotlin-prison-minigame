package com.cludivers.kz2wdprison.gameplay.commands.nation

import com.cludivers.kz2wdprison.framework.beans.nation.NationBean
import com.cludivers.kz2wdprison.gameplay.commands.SubCommand
import com.cludivers.kz2wdprison.gameplay.player.getData
import com.cludivers.kz2wdprison.gameplay.player.sendNotificationMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.hibernate.Session

class NationInfo(parentName: String, val session: Session) : SubCommand(parentName ){
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player){
            return false
        }

        val nation = sender.getData(session).nation
        if (nation is NationBean){
            sender.sendNotificationMessage(nation.description())
        } else {
            sender.sendNotificationMessage("Vous n'appartenez à aucune nation.")
            sender.sendNotificationMessage("/nation create pour en créer une")
            sender.sendNotificationMessage("/nation join <inviteur> pour en rejoindre une")
        }

        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): MutableList<String>? {
        return null
    }
}
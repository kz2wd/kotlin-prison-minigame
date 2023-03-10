package com.cludivers.kz2wdprison.gameplay.menu

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import org.bukkit.event.inventory.InventoryMoveItemEvent
import org.bukkit.inventory.Inventory

object MenuListener : Listener {

    private val allInventoryMenus = HashMap<Inventory, Menu>()

    fun addMenu(inventory: Inventory, menu: Menu){
        allInventoryMenus[inventory] = menu
    }


    @EventHandler
    fun onMenuClick(event: InventoryClickEvent){
        if (allInventoryMenus.contains(event.clickedInventory)){
            allInventoryMenus[event.clickedInventory]?.handleClick(event)
            event.isCancelled = true
        }
    }


    @EventHandler
    fun onMenuPlaceItem(event: InventoryMoveItemEvent){
        if (allInventoryMenus.contains(event.destination)){
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onMenuDragItem(event: InventoryDragEvent){
        if (allInventoryMenus.contains(event.inventory)){
            event.isCancelled = true
        }
    }

    @EventHandler
    fun onMenuClose(event: InventoryCloseEvent){
        allInventoryMenus.remove(event.inventory)
    }
}
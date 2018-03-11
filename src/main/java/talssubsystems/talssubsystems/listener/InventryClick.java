package talssubsystems.talssubsystems.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import talssubsystems.talssubsystems.manager.EnderChest;
import talssubsystems.talssubsystems.manager.InventoryManager;

public class InventryClick implements Listener {

    @EventHandler
    public void onInventory(InventoryClickEvent e)
    {
        //スロット
        if(e.getSlotType() == InventoryType.SlotType.OUTSIDE) return;

        //アイテムＴＹＰＥ　
        if(e.getCurrentItem().getType() == Material.AIR) return;

        //クリックしたときの名前があるか
        if(!e.getCurrentItem().getItemMeta().hasDisplayName())return;

        InventoryManager.setGMenu(e);
        InventoryManager.itemClick(e);
        EnderChest.clickEnderChest(e);
    }
}

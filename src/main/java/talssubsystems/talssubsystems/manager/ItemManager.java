package talssubsystems.talssubsystems.manager;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemManager {
    public static void setDrop(PlayerDropItemEvent e)
    {
        Player p = e.getPlayer();
        ItemStack item= e.getItemDrop().getItemStack();
        if(!item.getItemMeta().hasDisplayName())
        {
            return;
        }
        if(item.getItemMeta().getDisplayName().contains("§r§0§r§0§r"))
        {
            e.getItemDrop().setCustomName(item.getItemMeta().getDisplayName());
            e.getItemDrop().setCustomNameVisible(true);
        }
    }
}

package talssubsystems.talssubsystems.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import talssubsystems.talssubsystems.manager.EnderChest;
import talssubsystems.talssubsystems.manager.ItemManager;

public class ItemDrop implements Listener{

    @EventHandler
    public void onDrop(PlayerDropItemEvent e)
    {
        Player p = e.getPlayer();
        ItemManager.setDrop(e);
    }
}

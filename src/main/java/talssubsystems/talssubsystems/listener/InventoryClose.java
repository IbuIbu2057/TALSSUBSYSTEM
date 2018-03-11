package talssubsystems.talssubsystems.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import talssubsystems.talssubsystems.manager.EnderChest;

public class InventoryClose implements Listener {

    @EventHandler
    public void onClose(InventoryCloseEvent e)
    {
        EnderChest.cleseEnderChset(e);
    }
}

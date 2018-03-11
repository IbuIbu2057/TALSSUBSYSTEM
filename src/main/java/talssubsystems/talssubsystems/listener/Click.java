package talssubsystems.talssubsystems.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import talssubsystems.talssubsystems.manager.EnderChest;

public class Click implements Listener{


    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        //エンダーチェストクリックしたとき
        EnderChest.openEnderChest(e);
    }
}

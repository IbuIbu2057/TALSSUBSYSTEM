package talssubsystems.talssubsystems.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import talssubsystems.talssubsystems.manager.CreatePlayerFile;
import talssubsystems.talssubsystems.manager.InventoryManager;

public class JoinPlayer implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        InventoryManager.setBook(p);
        CreatePlayerFile.createData(p);
    }
}

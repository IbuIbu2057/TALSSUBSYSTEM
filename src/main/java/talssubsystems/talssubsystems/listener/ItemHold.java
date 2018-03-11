package talssubsystems.talssubsystems.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

public class ItemHold implements Listener {

    @EventHandler
    public void onHOLD(PlayerItemHeldEvent e)
    {
        Player p = e.getPlayer();
        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_HAT,1,2);
    }
}

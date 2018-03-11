package talssubsystems.talssubsystems.manager;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EnderChest {

    private static List<Player> ep =new ArrayList<>();

    public static void clickEnderChest(InventoryClickEvent e)
    {

        ItemStack item = e.getCurrentItem();

        if(item.getItemMeta().getDisplayName().contains("§d§m§r§b"))
        {
            if(item.getType() == Material.CHEST)
            {
                return;
            }

            Player p = (Player) e.getWhoClicked();

            //LISTから抜く
            if(ep.contains(p))
            {
                ep.remove(p);
            }

            //アイテム保存
            int page = Integer.parseInt(e.getClickedInventory().getTitle()
                    .replace("§s§r§l§r§5§lエンダーチェスト §b§l","").replace("§dページ",""));
            CreatePlayerFile.enderchest.put(p.getName()+"page" + page,e.getClickedInventory());

            //音
            p.playSound(p.getLocation(), Sound.ITEM_ARMOR_EQUIP_GOLD, 1.3f, 1.4f);

            //ページを変更
            p.openInventory(
                    CreatePlayerFile.enderchest.get(p.getName()+"page" +
                            Integer.parseInt(item.getItemMeta().getDisplayName()
                                    .replace("§d§m§r§b§l ","").replace(" §d§lページ",""))
                    ));

            //LISTに入れる
            if(!ep.contains(p))
            {
                ep.add(p);
            }
        }
    }

    public static void openEnderChest(PlayerInteractEvent e)
    {
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK)
        {
            return;
        }

        if(e.getClickedBlock().getType() != Material.ENDER_CHEST)
        {
            return;
        }

        e.setCancelled(true);
        Player p = e.getPlayer();
        p.playSound(p.getLocation(), Sound.BLOCK_ENDERCHEST_OPEN,1,1);
        p.openInventory(CreatePlayerFile.enderchest.get(p.getName()+"page1"));

        if(!ep.contains(p))
        {
            ep.add(p);
        }
    }

    public static void cleseEnderChset(InventoryCloseEvent e)
    {
        if(e.getInventory().getTitle().startsWith("§s§r§l§r§5§lエンダーチェスト §b"))
        {
            Player p = (Player) e.getPlayer();
            if(ep.contains(p))
            {
                ep.remove(p);

                p.playSound(e.getPlayer().getLocation(), Sound.BLOCK_ENDERCHEST_CLOSE, 1, 1);
            }
        }
    }
}

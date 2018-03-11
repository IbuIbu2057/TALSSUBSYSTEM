package talssubsystems.talssubsystems.manager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    public static void setGMenu(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();

        //クリックしたときのアイテム
        if(e.getCurrentItem().getItemMeta().
                getDisplayName().equals("§c§r§0§6§lグランドメニュー") )
        {
            e.setCancelled(true);
            p.chat("/gm");
        }
    }

    public static void itemClick(InventoryClickEvent e)
    {
        if(e.getCurrentItem().getItemMeta().getDisplayName().contains("§d§m§r"))
        {
            e.setCancelled(true);
        }
    }

    public static void setBook(Player p)
    {
        p.getInventory().setItem(17, Book());
    }

    //アイテム
    private static ItemStack Book()
    {
        //アイテム作成
        ItemStack item = new ItemStack(Material.BOOK);
        //ItemMeta取得
        ItemMeta itemmeta= item.getItemMeta();
        //名前
        itemmeta.setDisplayName("§c§r§0§6§lグランドメニュー");
        //LORE
        List<String> lore = new ArrayList<>();
        lore.add( "§7クリックすると");
        lore.add( "§7グランドメニューを開けます");
        lore.add( "§c※このアイテムは移動できません");
        //LOREセット
        itemmeta.setLore(lore);
        //エンチャント
        itemmeta.addEnchant(Enchantment.DURABILITY,1,true);
        //フラグ
        itemmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        //ItemMetaセット
        item.setItemMeta(itemmeta);
        return item;
    }
}

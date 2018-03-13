package talssubsystems.talssubsystems.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import talssubsystems.talssubsystems.TALSSUBSYSTEMS;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CreatePlayerFile {

    static TALSSUBSYSTEMS plugin = TALSSUBSYSTEMS.getPlugin(TALSSUBSYSTEMS.class);

    public static HashMap<String,Inventory> enderchest = new HashMap<>();
    public static ArrayList<Player> players = new ArrayList<>();

    public static void createData(Player player) {

        File directory = new File((Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder()), File.separator + "PlayerData");
        File playerData = new File(directory, File.separator + player.getUniqueId().toString() + ".yml");

        YamlConfiguration conf = YamlConfiguration.loadConfiguration(playerData);

        ItemStack[] item;
        ItemStack air,glass,chest,ender1,ender2,ender3,ender4,ender5,ender6,ender7,ender8,ender9;
        ItemMeta gl,c,en1,en2,en3,en4,en5,en6,en7,en8,en9;

        if (!playerData.exists()) {
            //アイテム
            air = new ItemStack(Material.AIR);
            glass = new ItemStack(Material.STAINED_GLASS_PANE);

            //チェスト
            chest = new ItemStack(Material.CHEST);

            //エンダーチェスト
            ender1 = new ItemStack(Material.ENDER_CHEST);
            ender2 = new ItemStack(Material.ENDER_CHEST);
            ender3 = new ItemStack(Material.ENDER_CHEST);
            ender4 = new ItemStack(Material.ENDER_CHEST);
            ender5 = new ItemStack(Material.ENDER_CHEST);
            ender6 = new ItemStack(Material.ENDER_CHEST);
            ender7 = new ItemStack(Material.ENDER_CHEST);
            ender8 = new ItemStack(Material.ENDER_CHEST);
            ender9 = new ItemStack(Material.ENDER_CHEST);

            //ItemMeta
            gl = glass.getItemMeta();
            //チェスト
            c = chest.getItemMeta();

            //エンダー
            en1 = ender1.getItemMeta();
            en2 = ender2.getItemMeta();
            en3 = ender3.getItemMeta();
            en4 = ender4.getItemMeta();
            en5 = ender5.getItemMeta();
            en6 = ender6.getItemMeta();
            en7 = ender7.getItemMeta();
            en8 = ender8.getItemMeta();
            en9 = ender9.getItemMeta();

            //名前設定
            gl.setDisplayName("§d§m§r");
            //チェスト
            c.setDisplayName("§d§m§r§b 1 §d§lページ §a選択中");
            //エンダー
            en1.setDisplayName("§d§m§r§b§l 1 §d§lページ");
            en2.setDisplayName("§d§m§r§b§l 2 §d§lページ");
            en3.setDisplayName("§d§m§r§b§l 3 §d§lページ");
            en4.setDisplayName("§d§m§r§b§l 4 §d§lページ");
            en5.setDisplayName("§d§m§r§b§l 5 §d§lページ");
            en6.setDisplayName("§d§m§r§b§l 6 §d§lページ");
            en7.setDisplayName("§d§m§r§b§l 7 §d§lページ");
            en8.setDisplayName("§d§m§r§b§l 8 §d§lページ");
            en9.setDisplayName("§d§m§r§b§l 9 §d§lページ");

            //ItemMetaセット
            glass.setItemMeta(gl);
            //チェスト
            chest.setItemMeta(c);
            //エンダー
            ender1.setItemMeta(en1);
            ender2.setItemMeta(en2);
            ender3.setItemMeta(en3);
            ender4.setItemMeta(en4);
            ender5.setItemMeta(en5);
            ender6.setItemMeta(en6);
            ender7.setItemMeta(en7);
            ender8.setItemMeta(en8);
            ender9.setItemMeta(en9);

            //for文で設定
            for(int i=1; i<10;i++)
            {
                //配列
                item = new ItemStack[]{air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,air, air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,air,glass,glass,glass,glass,glass,glass,glass,glass,glass,
                        ender1,ender2,ender3,ender4,ender5,ender6,ender7,ender8,ender9
                };

                //チェスト配置
                ItemMeta cm = chest.getItemMeta();
                cm.setDisplayName("§d§m§r§b§l "+i+" §d§lページ §a選択中");
                chest.setItemMeta(cm);
                item[44+i] = chest;

                //HashMap保存
                Inventory Inventory = Bukkit.createInventory(null, 54, "§s§r§l§r§5§lエンダーチェスト §b§l"+i+"§dページ");
                Inventory.setContents(item);
                enderchest.put(player.getName()+"page"+i,Inventory);

                //リスト追加
                if(!players.contains(player))
                {
                    players.add(player);
                }

                /* 保存 */
                conf.set("page"+i+"chest",item);

                //解禁設定
                if(i==1)
                {
                    conf.set("page1",true);
                    continue;
                }

                //ページ開放設定
                conf.set("page"+i,false);
            }
            try {
                conf.save(playerData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else//既にあった場合
        {
            //リスト追加
            if(players.contains(player))
            {
                return;
            }

            for(int i=1; i<10;i++)
            {
                //アイテム配列を作る
                item = ((List<ItemStack>) conf.get("page"+i+"chest")).toArray(new ItemStack[0]);
                //インベントリを制作
                Inventory Inventory = Bukkit.createInventory(null, 54, "§s§r§l§r§5§lエンダーチェスト §b§l"+i+"§dページ");
                Inventory.setContents(item);
                //保存
                enderchest.put(player.getName()+"page"+i,Inventory);
                //LIST追加
                players.add(player);
            }
        }
    }

    //onEnableのメゾット
    public static void playerEnderChset(Player player)
    {
        File directory = new File((Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder()), File.separator + "PlayerData");
        File playerData = new File(directory, File.separator + player.getUniqueId().toString() + ".yml");

        YamlConfiguration conf = YamlConfiguration.loadConfiguration(playerData);

        ItemStack[] item;

        //リスト追加
        if(players.contains(player))
        {
            return;
        }

        for(int i=1; i<10;i++)
        {
            //アイテム配列を作る
            item = ((List<ItemStack>) conf.get("page"+i+"chest")).toArray(new ItemStack[0]);
            //インベントリを制作
            Inventory Inventory = Bukkit.createInventory(null, 54, "§s§r§l§r§5§lエンダーチェスト §b§l"+i+"§dページ");
            Inventory.setContents(item);
            //保存
            enderchest.put(player.getName()+"page"+i,Inventory);
            //LIST追加
            players.add(player);

        }
    }

    public static void sevePlayerDeta(Player player)
    {
        player.closeInventory();
        //config取得
        File directory = new File((Bukkit.getServer().getPluginManager().getPlugin(plugin.getName()).getDataFolder()), File.separator + "PlayerData");
        File playerData = new File(directory, File.separator + player.getUniqueId().toString() + ".yml");

        YamlConfiguration conf = YamlConfiguration.loadConfiguration(playerData);

        for(int i=1; i<10;i++)
        {
            //保存
            conf.set("page"+i+"chest",enderchest.get(player.getName()+"page"+i).getContents());
        }

        try {
            conf.save(playerData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

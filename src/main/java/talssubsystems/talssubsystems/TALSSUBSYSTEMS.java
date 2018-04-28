package talssubsystems.talssubsystems;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import talssubsystems.talssubsystems.listener.*;
import talssubsystems.talssubsystems.manager.CreatePlayerFile;

import java.util.UUID;

public final class TALSSUBSYSTEMS extends JavaPlugin {

    String prefix = "§e≪§cT§6A§aL§bS §9SubSystem§e≫ ";

    CreatePlayerFile cpf;

    /***************************************************
     *                                                 *
     *   Copyright                                     *
     *           The After Life Story                  *
     *                              Rights Reserved    *
     *                                                 *
     ***************************************************/

    @Override
    public void onEnable() {

        //LOADメッセージ開始
        Bukkit.getConsoleSender().sendMessage(prefix+"§aLoading");

        cpf = new CreatePlayerFile();

        //リスナー
        getServer().getPluginManager().registerEvents(new InventryClick(), this);
        getServer().getPluginManager().registerEvents(new Click(), this);
        getServer().getPluginManager().registerEvents(new JoinPlayer(), this);
        getServer().getPluginManager().registerEvents(new ItemDrop(), this);
        getServer().getPluginManager().registerEvents(new ItemHold(), this);
        getServer().getPluginManager().registerEvents(new InventoryClose(), this);

        //エンダーチェストのロード
        for(Player p : getServer().getOnlinePlayers())
        {
            CreatePlayerFile.playerEnderChset(p);
        }

        //LOADメッセージ終了
        Bukkit.getConsoleSender().sendMessage(prefix+"§aFinish loading");
    }

    @Override
    public void onDisable() {
        for(Player player : CreatePlayerFile.players)
        {
            CreatePlayerFile.sevePlayerDeta(player);
        }
    }
}

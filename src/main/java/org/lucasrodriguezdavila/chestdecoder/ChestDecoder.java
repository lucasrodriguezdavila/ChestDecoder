package org.lucasrodriguezdavila.chestdecoder;


import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.lucasrodriguezdavila.chestdecoder.commands.Decode;
import org.lucasrodriguezdavila.chestdecoder.commands.Lock;
import org.lucasrodriguezdavila.chestdecoder.listeners.ChestOpen;
import org.lucasrodriguezdavila.chestdecoder.listeners.ChestPlace;

public final class ChestDecoder extends JavaPlugin {

    public static final String CODE = "chestdecoder_code";

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ChestOpen(), this);
        pm.registerEvents(new ChestPlace(), this);

        this.getCommand("decode").setExecutor(new Decode());
        this.getCommand("lock").setExecutor(new Lock());

        getServer().getWorld("world").setTime(0);
        getServer().getWorld("world").setDifficulty(org.bukkit.Difficulty.PEACEFUL);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}

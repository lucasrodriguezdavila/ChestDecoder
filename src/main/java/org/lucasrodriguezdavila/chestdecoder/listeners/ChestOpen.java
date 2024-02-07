package org.lucasrodriguezdavila.chestdecoder.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.TileState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.lucasrodriguezdavila.chestdecoder.ChestDecoder;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformation;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformationDataType;

public class ChestOpen implements Listener {

    @EventHandler
    public void onOpen(PlayerInteractEvent event) {
        if (!event.hasBlock()) {
            return;
        }
        if (event.getClickedBlock().getType() != Material.CHEST) {
            return;
        }

        if (!(event.getClickedBlock().getState() instanceof TileState)) {
            return;
        }

        TileState state = (TileState) event.getClickedBlock().getState();
        PersistentDataContainer container = state.getPersistentDataContainer();

        NamespacedKey key = new NamespacedKey(ChestDecoder.getPlugin(ChestDecoder.class), ChestDecoder.CODE);

        if (!container.has(key, new PrivateChestInformationDataType())) {
            return;
        }

        PrivateChestInformation chest = container.get(key, new PrivateChestInformationDataType());
        Player player = event.getPlayer();
        String playerID = player.getUniqueId().toString();


        if (!chest.hasPlayerID(playerID)) {
            player.sendMessage(ChatColor.RED + "You don't have access to this chest");
            event.setCancelled(true);
            return;
        }


    }
}

package org.lucasrodriguezdavila.chestdecoder.listeners;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Chest;
import org.bukkit.block.TileState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.lucasrodriguezdavila.chestdecoder.ChestDecoder;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformation;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformationDataType;

public class ChestPlace implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
//        if (event.getBlock().getType() != Material.CHEST) {
//            return;
//        }
//
//        if (!(event.getBlock().getState() instanceof TileState)) {
//            return;
//        }
//
//        TileState state = (TileState) event.getBlock().getState();
//        PersistentDataContainer container = state.getPersistentDataContainer();
//
//        NamespacedKey key = new NamespacedKey(ChestDecoder.getPlugin(ChestDecoder.class), ChestDecoder.CODE);
//
//        PrivateChestInformation chest = new PrivateChestInformation(event.getPlayer().getUniqueId().toString(), "1234");
//        chest.addPlayerID(event.getPlayer().getUniqueId().toString());
//
//        container.set(key, new PrivateChestInformationDataType(), chest);
//
//        state.update();
//
//
//        event.getPlayer().sendMessage("Chest locked!");
//        event.getPlayer().sendMessage("Chest code: " + chest.getHashedCode());
//        event.getPlayer().sendMessage("User " + chest.getPlayerID());
//

    }

}

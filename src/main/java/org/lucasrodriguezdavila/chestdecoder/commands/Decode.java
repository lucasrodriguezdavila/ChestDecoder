package org.lucasrodriguezdavila.chestdecoder.commands;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.TileState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.lucasrodriguezdavila.chestdecoder.ChestDecoder;
import org.lucasrodriguezdavila.chestdecoder.PrivateChestKeys;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformation;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformationDataType;

public class Decode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return false;
        }

        Player player = (Player) sender;

        if (args == null || args.length == 0) {
            player.sendMessage(ChatColor.RED + "You must provide a code");
            return true;
        }

        String code = args[0];

        Block block = player.getTargetBlock(null, 5);

        if (!block.getType().toString().contains("CHEST")) {
            player.sendMessage(ChatColor.RED + "No chest found");
            return true;
        }

        TileState state = (TileState) block.getState();
        PersistentDataContainer container = state.getPersistentDataContainer();

        NamespacedKey key = new NamespacedKey(ChestDecoder.getPlugin(ChestDecoder.class), ChestDecoder.CODE);

        if (!container.has(key, new PrivateChestInformationDataType())) {
            player.sendMessage(ChatColor.RED + "No chest found");
            return true;
        }


        PrivateChestInformation chest = container.get(key, new PrivateChestInformationDataType());
        String uniqueId = player.getUniqueId().toString();

        if (!chest.hasPlayerID(uniqueId)) {
            if (!chest.isCode(code)) {
                player.sendMessage(ChatColor.RED + "Invalid code");
                return true;
            }

            player.sendMessage(ChatColor.YELLOW + "You have now access to this chest");
            chest.addPlayerID(uniqueId);
            container.set(key, new PrivateChestInformationDataType(), chest);
            state.update();
            return true;
        } else {
            player.sendMessage("You already have access to this chest");
        }


        return true;
    }
}

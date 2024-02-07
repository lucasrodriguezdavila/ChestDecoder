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
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformation;
import org.lucasrodriguezdavila.chestdecoder.models.PrivateChestInformationDataType;

public class Lock implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command");
            return false;
        }
        Player player = (Player) sender;
        Block block = player.getTargetBlock(null, 5);

        if (!block.getType().toString().contains("CHEST")) {
            player.sendMessage(ChatColor.RED + "No chest found");
            return true;
        }

        if (args == null || args.length == 0) {
            player.sendMessage(ChatColor.RED + "You must provide a code");
            return true;
        }

        String code = args[0];

        if (code == null) {
            player.sendMessage(ChatColor.RED + "You must provide a code");
            return true;
        }

        if (code.length() < 4) {
            player.sendMessage(ChatColor.RED + "Code must be at least 4 digits long");
            return true;
        }

        TileState state = (TileState) block.getState();
        PersistentDataContainer container = state.getPersistentDataContainer();
        String uniqueID = player.getUniqueId().toString();

        NamespacedKey key = new NamespacedKey(ChestDecoder.getPlugin(ChestDecoder.class), ChestDecoder.CODE);

        PrivateChestInformation chest = new PrivateChestInformation(uniqueID, code);
        chest.addPlayerID(uniqueID);

        container.set(key, new PrivateChestInformationDataType(), chest);

        state.update();

        player.sendMessage(ChatColor.YELLOW + "Chest locked!");

        return true;
    }
}

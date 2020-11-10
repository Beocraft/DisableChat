package net.beocraft.plugins.disablechat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CustomCommandExecutor implements CommandExecutor, TabCompleter {

    private static final String[] POSSIBLE_VALUES = {"enable", "disable"};
    private final FileConfiguration config;
    private final Logger logger;

    public CustomCommandExecutor(FileConfiguration config, Logger logger) {
        this.config = config;
        this.logger = logger;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(DisableChat.ADMIN_PERMISSION)) {
                // Player with Admin permission
                return commandExecutor(player, args);
            }
        } else {
            // Console or RemoteConsole
            return commandExecutor(sender, args);
        }
        return false;
    }

    private boolean commandExecutor(CommandSender sender, String[] args) {
        if (args.length == 0) {
            if (config.getBoolean(DisableChat.YAML_BOOLEAN_PATH)) {
                // Enabled
                sender.sendMessage(prefix(true));
            } else {
                // Disabled
                sender.sendMessage(prefix(false));
            }
            return true;
        } else {
            if (args.length == 1) {
                if (args[0].equals(POSSIBLE_VALUES[0])) {
                    // Enabled
                    config.set(DisableChat.YAML_BOOLEAN_PATH, true);
                    sender.sendMessage(prefix(true));
                    logger.info("Chat blocking is now enabled");
                    return true;
                }
                if (args[0].equals(POSSIBLE_VALUES[1])) {
                    // Disabled
                    config.set(DisableChat.YAML_BOOLEAN_PATH, false);
                    sender.sendMessage(prefix(false));
                    logger.info("Chat blocking is now disabled");
                    return true;
                }
            }
        }
        return false;
    }

    private String prefix(boolean enabled) {
        // Adds a prefix to message
        String message = "Chat blocking is ";
        if (enabled) {
            message += ChatColor.GREEN + "enabled";
        } else {
            message += ChatColor.RED + "disabled";
        }
        return String.format("%s%s[DisableChat]%s %s", ChatColor.GOLD, ChatColor.BOLD, ChatColor.RESET, message);
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        ArrayList<String> result = new ArrayList<>();

        if (args.length == 1) {
            for (String arg : POSSIBLE_VALUES) {
                if (arg.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(arg);
                }
            }
        }
        return result;
    }
}

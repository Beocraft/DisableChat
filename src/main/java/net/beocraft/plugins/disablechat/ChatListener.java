package net.beocraft.plugins.disablechat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final FileConfiguration config;

    public ChatListener(FileConfiguration config) {
        this.config = config;
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (!(player.hasPermission(DisableChat.BYPASS_PERMISSION) || player.hasPermission(DisableChat.ADMIN_PERMISSION))) {
            event.setCancelled(config.getBoolean(DisableChat.YAML_BOOLEAN_PATH));
        }

    }
}

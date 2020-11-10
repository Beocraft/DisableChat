package net.beocraft.plugins.disablechat;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class DisableChat extends JavaPlugin {

    public static final String ADMIN_PERMISSION = "disablechat.admin";
    public static final String BYPASS_PERMISSION = "disablechat.bypass";
    public static final String YAML_BOOLEAN_PATH = "enabled";

    @Override
    public void onEnable() {
        // Init
        Logger logger = getLogger();
        FileConfiguration config = getConfig();

        // Reading from configuration file
        logger.info("Loading configuration");
        config.options().copyDefaults();
        saveDefaultConfig();

        // Display current configuration
        if (getConfig().getBoolean(YAML_BOOLEAN_PATH)) {
            logger.info("Plugin is enabled, any chat attempt will be blocked");
        } else {
            logger.info("Plugin is disabled, anyone can chat");
        }

        // Registration
        getServer().getPluginManager().registerEvents(new ChatListener(config), this);
        Objects.requireNonNull(getCommand("disablechat")).setExecutor(new CustomCommandExecutor(config,logger));
    }

}

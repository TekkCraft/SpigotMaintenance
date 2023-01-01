package org.example.spigotmavenbase;

import org.example.spigotmavenbase.command.ExampleCommand;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.example.spigotmavenbase.listener.PlayerJoinListener;

/**
 * The main class of your plugin.
 */
public class Main extends JavaPlugin {

    /** Configuration data from config.yml */
    private FileConfiguration config;

    /**
     * Method that is called when your plugin is loaded on the server.
     * E.g.: server start
     */
    @Override
    public void onEnable() {
        this.ensureConfig();

        // Register command
        this.getCommand("example").setExecutor(new ExampleCommand(this.config));

        // Register event
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    /**
     * Method that is called when your plugin is unloaded on the server.
     * E.g.: server shutdown
     */
    @Override
    public void onDisable() {
    }

    /**
     * Make sure that all required config files exist.
     */
    private void ensureConfig() {
        // Copies your default config into the plugin config folder on the server
        // if the config.yml files does not yet exist there.
        this.saveDefaultConfig();
        // Reloads configuration from disk
        this.reloadConfig();

        // Make configuration accessible in the this.config private variable
        this.config = this.getConfig();
    }
}
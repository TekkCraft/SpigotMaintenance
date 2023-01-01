package ch.tekk.spigotmaintenance.domain.maintenance;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class MaintenanceDisabler {

    private final FileConfiguration config;
    private final Plugin plugin;

    public MaintenanceDisabler(FileConfiguration config, Plugin plugin) {
        this.config = config;
        this.plugin = plugin;
    }

    /**
     * Enable maintenance mode
     */
    public boolean disable(CommandSender sender) {
        if (!sender.hasPermission("spigotmaintenance.disable") && !sender.isOp()) {
            sender.sendMessage("You do not have permission to use this command");

            return true;
        }

        if (!this.config.getBoolean("maintenance")) {
            sender.sendMessage("Maintenance mode is already turned off");

            return true;
        }

        this.config.set("maintenance", false);

        this.plugin.saveConfig();

        sender.sendMessage("Maintenance finished");

        return true;
    }
}

package ch.tekk.spigotmaintenance.domain.maintenance;

import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class MaintenanceStatus {

    private final FileConfiguration config;

    public MaintenanceStatus(FileConfiguration config) {
        this.config = config;
    }

    /**
     * Check if maintenance mode is enabled
     */
    public boolean checkMaintenanceMode(CommandSender sender) {
        if (!sender.hasPermission("spigotmaintenance.info") && !sender.isOp()) {
            sender.sendMessage("You do not have permission to use this command");

            return true;
        }

        boolean maintenance = this.config.getBoolean("maintenance");

        String status = "disabled";
        if (maintenance) {
            status = "enabled";
        }

        sender.sendMessage("Maintenance mode is " + status);

        return true;
    }
}

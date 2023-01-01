package ch.tekk.spigotmaintenance.domain.maintenance;

import ch.tekk.spigotmaintenance.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MaintenanceEnabler {

    private final FileConfiguration config;
    private final Plugin plugin;

    public MaintenanceEnabler(FileConfiguration config, Plugin plugin) {
        this.config = config;
        this.plugin = plugin;
    }


    /**
     * Enable maintenance mode
     */
    public boolean enable(CommandSender sender) {
        if (!sender.hasPermission("spigotmaintenance.enable") && !sender.isOp()) {
            sender.sendMessage("You do not have permission to use this command");

            return true;
        }

        if (this.config.getBoolean("maintenance")) {
            sender.sendMessage("Maintenance mode is already turned on");

            return true;
        }

        this.config.set("maintenance", true);

        this.plugin.saveConfig();

        this.kickPlayers();

        sender.sendMessage("Server has been put into maintenance mode");

        return true;
    }

    /**
     * Kick all online players that do not have the bypass permission.
     */
    private void kickPlayers() {
        String kickMessage = this.config.getString("maintenanceMessage");

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("spigotmaintenance.bypass")) {
                continue;
            }

            if (player.isOp()) {
                continue;
            }

            player.kickPlayer(kickMessage);
        }
    }
}

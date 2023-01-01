package ch.tekk.spigotmaintenance.listener;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Example event listener class
 */
public class PlayerJoinListener implements Listener {

    private final FileConfiguration config;

    public PlayerJoinListener(FileConfiguration config) {
        this.config = config;
    }

    /**
     * Method that is called on player join event
     *
     * @param event Player join event
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!this.config.getBoolean("maintenance")) {
            return;
        }

        Player player = event.getPlayer();

        if (player.hasPermission("spigotmaintenance.bypass") || player.isOp()) {
            return;
        }

        String kickMessage = this.config.getString("maintenanceMessage");

        player.kickPlayer(kickMessage);
    }
}

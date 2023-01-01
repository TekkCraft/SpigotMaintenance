package org.example.spigotmavenbase.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Example event listener class
 */
public class PlayerJoinListener implements Listener {

    /**
     * Method that is called on player join event
     *
     * @param event Player join event
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.WHITE + "Welcome " + ChatColor.GOLD + player.getDisplayName() + ChatColor.WHITE + "!");
    }
}

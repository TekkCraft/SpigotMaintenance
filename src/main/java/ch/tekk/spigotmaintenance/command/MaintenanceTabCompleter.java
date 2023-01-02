package ch.tekk.spigotmaintenance.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceTabCompleter implements TabCompleter {

    private final FileConfiguration config;

    public MaintenanceTabCompleter(FileConfiguration config) {
        this.config = config;
    }

    /**
     * Complete tabs
     */
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        ArrayList<String> tabList = new ArrayList<String>();

        this.enableTab(sender, args, tabList);
        this.disableTab(sender, args, tabList);

        tabList.removeIf(s -> !(s.toLowerCase().startsWith(args[args.length - 1].toLowerCase())));

        return tabList;
    }

    /**
     * Tab complete for enable
     */
    private void enableTab(CommandSender sender, String[] args, ArrayList<String> tabList) {
        if (!sender.hasPermission("spigotmaintenance.enable")) {
            return;
        }

        if (this.config.getBoolean("maintenance")) {
            return;
        }

        if (args.length <= 1) {
            tabList.add("enable");
        }
    }

    /**
     * Tab complete for disable
     */
    private void disableTab(CommandSender sender, String[] args, ArrayList<String> tabList) {
        if (!sender.hasPermission("spigotmaintenance.disable")) {
            return;
        }

        if (!this.config.getBoolean("maintenance")) {
            return;
        }

        if (args.length <= 1) {
            tabList.add("disable");
        }
    }
}

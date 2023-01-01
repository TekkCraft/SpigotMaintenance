package ch.tekk.spigotmaintenance.command;

import ch.tekk.spigotmaintenance.Main;
import ch.tekk.spigotmaintenance.domain.maintenance.MaintenanceDisabler;
import ch.tekk.spigotmaintenance.domain.maintenance.MaintenanceEnabler;
import ch.tekk.spigotmaintenance.domain.maintenance.MaintenanceStatus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

/**
 * Example command class
 */
public class MaintenanceAction implements CommandExecutor {

    private final MaintenanceEnabler enabler;
    private final MaintenanceDisabler disabler;
    private final MaintenanceStatus maintenanceStatus;

    /**
     * Constructor.
     * This method will always be called first when the class is initialized.
     */
    public MaintenanceAction(FileConfiguration config, Plugin plugin) {
        this.enabler = new MaintenanceEnabler(config, plugin);
        this.disabler = new MaintenanceDisabler(config, plugin);
        this.maintenanceStatus = new MaintenanceStatus(config);
    }

    /**
     * Method that will be called when the command is executed.
     *
     * @param sender The command sender
     * @param cmd The command
     * @param label The command label
     * @param args The command arguments
     *
     * @return void
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            return this.maintenanceStatus.checkMaintenanceMode(sender);
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("enable")) {
            return this.enabler.enable(sender);
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("disable")) {
            return this.disabler.disable(sender);
        }

        return true;
    }
}

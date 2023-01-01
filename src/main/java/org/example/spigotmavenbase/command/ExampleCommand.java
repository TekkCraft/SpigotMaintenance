package org.example.spigotmavenbase.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Example command class
 */
public class ExampleCommand implements CommandExecutor {

    /** The configuration */
    private FileConfiguration config;

    /**
     * Constructor.
     * This method will always be called first when the class is initialized.
     */
    public ExampleCommand(FileConfiguration config) {
        this.config = config;
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
        // Check if command sender has permission to use the command
        if (!sender.hasPermission("spigotmavenbase.example")) {
            sender.sendMessage("You do not have permission to use this command");
            sender.sendMessage(sender.getClass().descriptorString());

            return false;
        }

        // Get exampleMessage from config.yml
        String message = config.getString("exampleMessage");

        // Overwrite message if it is nothing is set in the config
        if (message == null) {
            message = "\"exampleMessage\" in config.yml is not set";
        }

        // Send message to player
        sender.sendMessage(message);

        return true;
    }
}

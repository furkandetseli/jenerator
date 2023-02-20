package furkandetseli.jenerator.Komutlar;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class domsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player p) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Lütfen bir mesaj girin.");
                return false;
            }
            String message = String.join(" ", args);
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getLocation().distance(p.getLocation()) <= 14) {
                    player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + p.getDisplayName() + " " + message);
                }
            }
        }
        return true;
    }
}

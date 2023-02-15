package furkandetseli.jenerator.Komutlar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class domsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String mesaj = args[0];
        Player player = (Player) sender;
        player.sendMessage(ChatColor.GREEN + mesaj);
        return true;
    }
}

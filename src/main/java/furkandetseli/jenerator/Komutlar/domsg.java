package furkandetseli.jenerator.Komutlar;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class domsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String allmsg = "";
        for(int a = 0; a < args.length; a++){
            allmsg += args[a]+" ";
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.of("#1BCB99") + "" + org.bukkit.ChatColor.ITALIC + player.getDisplayName() + " " + allmsg);
        return true;
    }
}

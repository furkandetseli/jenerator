package furkandetseli.jenerator.Komutlar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class memsg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String allmsg = "";
        for(int a = 0; a < args.length; a++){
            allmsg += args[a]+" ";
        }
        Player player = (Player) sender;
        player.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + player.getDisplayName() + " " + allmsg);
        return true;
    }
}

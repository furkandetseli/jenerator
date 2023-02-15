package furkandetseli.jenerator.Eventler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Chatrenk implements Listener {
    @EventHandler
    public void renkler(AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        String mesaj = event.getMessage();
        mesaj = ChatColor.YELLOW + mesaj;
        event.setMessage(mesaj);
    }
}

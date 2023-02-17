package furkandetseli.jenerator.Eventler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatAlanEvent implements Listener {
    @EventHandler
    public void onChatMsg(AsyncPlayerChatEvent event){
        Player sender = event.getPlayer();
        String mesaj = event.getMessage();
        for (Player alıcı: sender.getWorld().getPlayers()) {
            if(alıcı.getLocation().distance(sender.getLocation()) < 14){
                alıcı.sendMessage(mesaj);
            }
        }
        event.setCancelled(true);
    }
}

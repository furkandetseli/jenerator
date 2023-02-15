package furkandetseli.jenerator.Eventler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class Scoreboards implements Listener {
    @EventHandler
    public void Tablo(PlayerJoinEvent event){
        Player player = event.getPlayer();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("Avar","Craft","Tarih");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Avarcraft");

        Score deneme = obj.getScore(ChatColor.YELLOW + "AVARCRAFT");
        deneme.setScore(1);
        player.setScoreboard(board);
    }
}

package furkandetseli.jenerator.Eventler;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import java.util.*;

public class Scoreboards implements Listener {
    public static Set<UUID> playerset = new HashSet<>();
    @EventHandler
    public void Tablo(PlayerJoinEvent event){
        Player player = event.getPlayer();

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        if (!playerset.contains(player.getUniqueId())) {
            playerset.add(player.getUniqueId());
        }
        Objective obj = board.registerNewObjective("Avar","Craft","Tarih");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GREEN.toString() + ChatColor.BOLD + "Avarcraft");


        Bukkit.getScheduler().runTaskTimer(JavaPlugin.getProvidingPlugin(getClass()), new Runnable() {
            @Override
            public void run() {
                Score isim = obj.getScore(ChatColor.GREEN + player.getDisplayName());
                isim.setScore(6);
                Score blank = obj.getScore(" ");
                blank.setScore(5);

                Score players = obj.getScore(ChatColor.WHITE + "Aktif oyuncular: ");
                players.setScore(4);

                Score online = obj.getScore(ChatColor.GREEN.toString() + playerset.size());
                online.setScore(3);


                Score blank1 = obj.getScore("  ");
                blank1.setScore(2);

                Score balance = obj.getScore(ChatColor.WHITE + "Paranız: ");
                balance.setScore(1);



                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("minecraftdb");
                    MongoCollection<Document> collection = database.getCollection("users");

                    Document filterdoc = new Document("uuid", player.getUniqueId())
                            .append("username", player.getName())
                            .append("loggedin", true);
                    Document varmi = collection.find(filterdoc).first();
                    if (varmi != null) {
                        Integer para = varmi.getInteger("para");
                        Score money = obj.getScore(ChatColor.GREEN.toString() + para + " Altın");
                        money.setScore(0);
                    }

                }



            }
        }, 0L, 20L);

        player.setScoreboard(board);

    }
    @EventHandler
    public void cikisEvent(PlayerQuitEvent e){
        Player p = e.getPlayer();
        playerset.remove(p.getUniqueId());
    }

}

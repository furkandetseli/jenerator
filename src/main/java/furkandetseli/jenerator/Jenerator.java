package furkandetseli.jenerator;

import furkandetseli.jenerator.Eventler.Chatrenk;
import org.bukkit.plugin.java.JavaPlugin;
import furkandetseli.jenerator.Eventler.Scoreboards;
public final class Jenerator extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("JENERATOR AKTIF!");
        getServer().getPluginManager().registerEvents(new Scoreboards(), this);
        getServer().getPluginManager().registerEvents(new Chatrenk(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown login
    }
}

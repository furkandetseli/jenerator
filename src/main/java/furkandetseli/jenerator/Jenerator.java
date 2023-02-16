package furkandetseli.jenerator;

import furkandetseli.jenerator.Eventler.Chatrenk;
import furkandetseli.jenerator.Komutlar.domsg;
import furkandetseli.jenerator.Komutlar.memsg;
import org.bukkit.plugin.java.JavaPlugin;
import furkandetseli.jenerator.Eventler.Scoreboards;
public final class Jenerator extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("JENERATOR AKTIF!");
        getCommand("do").setExecutor(new domsg());
        getCommand("me").setExecutor(new memsg());

        getServer().getPluginManager().registerEvents(new Scoreboards(), this);
        getServer().getPluginManager().registerEvents(new Chatrenk(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown login
    }
}

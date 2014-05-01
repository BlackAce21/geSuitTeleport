package net.cubespace.geSuitTeleports.tasks;

import net.cubespace.geSuitTeleports.geSuitTeleports;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.ByteArrayOutputStream;

public class PluginMessageTask extends BukkitRunnable {

    private final ByteArrayOutputStream bytes;

    public PluginMessageTask( ByteArrayOutputStream bytes ) {
        this.bytes = bytes;
    }

    public PluginMessageTask( ByteArrayOutputStream b, boolean empty ) {
        this.bytes = b;
    }

    @SuppressWarnings("unchecked")
    public void run() {
        Player[] players = Bukkit.getOnlinePlayers();
        if ( players.length == 0 ) {
            return;
        }
        Player p = Bukkit.getOnlinePlayers()[0];
        if ( p == null ) {
            return;
        }
        p.sendPluginMessage( geSuitTeleports.instance, "geSuitTeleport", bytes.toByteArray() );
    }


}
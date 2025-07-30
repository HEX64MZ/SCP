package hxtedme.staffcontrol.util;

import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;

public class VelocityUtils {
    public static void broadcast(ProxyServer server, String permission, Component message) {
        server.getAllPlayers().forEach(player -> {
            if (player.hasPermission(permission)) {
                player.sendMessage(message);
            }
        });
    }
}

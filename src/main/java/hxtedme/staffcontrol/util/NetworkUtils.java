package hxtedme.staffcontrol.util;

import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import java.util.Collection;

public class NetworkUtils {
    public static void broadcast(ProxyServer server, String permission, String message) {
        Collection<RegisteredServer> servers = server.getAllServers();
        // Implementation for network-wide broadcasts
    }
}

package hxtedme.staffcontrol.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.DisconnectEvent;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import hxtedme.staffcontrol.StaffControlPlugin;

public class JoinLeaveListener {
    private final StaffControlPlugin plugin;

    public JoinLeaveListener(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onPostLogin(PostLoginEvent event) {
        // Handle player join events here
        if (plugin.getConfigManager().isSilentJoinEnabled()) {
            // Logic for silent join
        }
    }

    @Subscribe
    public void onDisconnect(DisconnectEvent event) {
        // Handle player leave events here
    }
}

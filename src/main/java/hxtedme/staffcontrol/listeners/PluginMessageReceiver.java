package hxtedme.staffcontrol.listeners;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PluginMessageEvent;
import hxtedme.staffcontrol.StaffControlPlugin;

public class PluginMessageReceiver {
    private final StaffControlPlugin plugin;

    public PluginMessageReceiver(StaffControlPlugin plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onPluginMessage(PluginMessageEvent event) {
        // Handle incoming plugin messages for cross-server communication
        String message = event.getMessage();
        // Process the message accordingly
    }
}
